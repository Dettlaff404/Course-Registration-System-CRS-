package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.EnrollmentDao;
import dao.custom.PrerequisiteDao;
import dto.CourseDto;
import entity.CourseEntity;
import entity.EnrollmentEntity;
import entity.PrerequisiteEntity;
import service.custom.StudentCourseSearchService;

public class StudentCourseSearchIMPL implements StudentCourseSearchService {

    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);
    private PrerequisiteDao prerequisiteDao = (PrerequisiteDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.PREREQUISITE);
    private EnrollmentDao enrollmentDao = (EnrollmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ENROLLMENT);

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
    public boolean canEnroll(String student_id, String courseId) throws Exception {
        ArrayList<PrerequisiteEntity> prerequisiteEntities = prerequisiteDao.getPrereqs(courseId);
        ArrayList<EnrollmentEntity> enrollmentEntities = enrollmentDao.searchByStudentIdCompleted(student_id);

        if (prerequisiteEntities.size() == 0) {
            return true;
        }

        int count = 0;
        for (PrerequisiteEntity prerequisiteEntity : prerequisiteEntities) {
            for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
                if (prerequisiteEntity.getPrereq_id().equals(enrollmentEntity.getCourse_id()) && enrollmentEntity.getGrade() != 'F') {
                    count++;
                    break;
                }
            }
        }

        if (count == prerequisiteEntities.size()) {
            return true;
        }

        return false;
    }

    @Override
    public String enrollCourse(String student_id, String courseId) throws Exception {
        return null;
    }

}
