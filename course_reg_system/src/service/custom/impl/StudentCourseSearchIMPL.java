package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dto.CourseDto;
import entity.CourseEntity;
import service.custom.StudentCourseSearchService;

public class StudentCourseSearchIMPL implements StudentCourseSearchService {

    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);

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
        return false;
    }

    @Override
    public String enrollCourse(String student_id, String courseId) throws Exception {
        return null;
    }

}
