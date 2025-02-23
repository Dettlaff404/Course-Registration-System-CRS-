package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dto.CourseDto;
import entity.CourseEntity;
import service.custom.Admin_CoursePanelService;

public class Admin_CoursePanelServiceIMPL implements Admin_CoursePanelService{

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
    public boolean saveCourse(CourseDto courseDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCourse'");
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }

}
