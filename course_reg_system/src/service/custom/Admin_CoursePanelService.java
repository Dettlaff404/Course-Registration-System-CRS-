package service.custom;

import java.util.ArrayList;

import dto.CourseDto;
import service.SuperService;

public interface Admin_CoursePanelService extends SuperService{
    public ArrayList<CourseDto> getAllCourses() throws Exception;
    public boolean saveCourse(CourseDto courseDto) throws Exception;
    public boolean deleteCourse(String courseId) throws Exception;
}
