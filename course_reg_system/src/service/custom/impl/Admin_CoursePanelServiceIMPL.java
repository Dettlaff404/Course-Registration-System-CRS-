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

}
