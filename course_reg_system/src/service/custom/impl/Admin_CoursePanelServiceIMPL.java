package service.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.EnrollmentDao;
import dao.custom.StudentDao;
import db.DBConnection;
import dto.CourseDto;
import dto.EnrollmentDto;
import entity.CourseEntity;
import entity.EnrollmentEntity;
import service.custom.Admin_CoursePanelService;

public class Admin_CoursePanelServiceIMPL implements Admin_CoursePanelService{

    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);
    private EnrollmentDao enrollmentDao = (EnrollmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ENROLLMENT);
    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public ArrayList<CourseDto> getAllCourses() throws Exception {
        ArrayList<CourseEntity> courseEntities = courseDao.getAll();
        ArrayList<CourseDto> courseDtos = new ArrayList<>();

        for (CourseEntity courseEntity : courseEntities) {
            courseDtos.add(new CourseDto(
                    courseEntity.getCourse_id(),
                    courseEntity.getTitle(),
                    courseEntity.getCred_hrs(), 
                    courseEntity.getMax_enrollcap(),
                    courseEntity.getDepartment_id()
            ));
        }
        return courseDtos;
    }

    @Override
    public boolean saveCourse(CourseDto courseDto) throws Exception {
        CourseEntity courseEntity = courseDao.searchById(courseDto.getCourse_id());
        if (courseEntity == null) {
            return courseDao.save(new CourseEntity(
                    courseDto.getCourse_id(),
                    courseDto.getTitle(),
                    courseDto.getCred_hrs(),
                    courseDto.getMax_enrollcap(),
                    courseDto.getDepartment_id()
            ));
            
        } else {
            return courseDao.update(new CourseEntity(
                    courseDto.getCourse_id(),
                    courseDto.getTitle(),
                    courseDto.getCred_hrs(),
                    courseDto.getMax_enrollcap(),
                    courseDto.getDepartment_id()
            ));
        }
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
        return courseDao.delete(courseId);
    }

    @Override
    public ArrayList<EnrollmentDto> getCoursesToBeGraded(String courseId) throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = enrollmentDao.searchByCourseIdCurrentlyFollowing(courseId);
        ArrayList<EnrollmentDto> enrollmentDtos = new ArrayList<>();

        for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
            enrollmentDtos.add(new EnrollmentDto(
                enrollmentEntity.getStudent_id(),
                studentDao.searchById(enrollmentEntity.getStudent_id()).getStudent_name(),
                enrollmentEntity.getCourse_id(),
                courseDao.searchById(enrollmentEntity.getCourse_id()).getTitle(),
                enrollmentEntity.getSemester(),
                enrollmentEntity.getGrade(),
                enrollmentEntity.getId()
            ));
        }
        return enrollmentDtos;
    }

    @Override
    public boolean gradeEnrollment(Integer enrollmentId, Character grade) throws Exception {
        EnrollmentEntity enrollmentEntity = enrollmentDao.searchById(Integer.toString(enrollmentId)); 
        enrollmentEntity.setGrade(grade);

        return enrollmentDao.update(enrollmentEntity);
    }

    @Override
    public boolean deleteEnrollment(Integer enrollmentId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
             
            CourseEntity courseEntity = courseDao.searchById(enrollmentDao.searchById(Integer.toString(enrollmentId)).getCourse_id());
            courseEntity.setMax_enrollcap(courseEntity.getMax_enrollcap() + 1);

            if (enrollmentDao.delete(Integer.toString(enrollmentId)) && courseDao.update(courseEntity)) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
            
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
