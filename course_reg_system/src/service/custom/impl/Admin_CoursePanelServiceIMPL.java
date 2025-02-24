package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.EnrollmentDao;
import dao.custom.StudentDao;
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

}
