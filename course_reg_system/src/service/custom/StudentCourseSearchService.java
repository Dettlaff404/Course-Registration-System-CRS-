package service.custom;

import java.util.ArrayList;

import dto.CourseDto;
import service.SuperService;

public interface StudentCourseSearchService extends SuperService {
    public ArrayList<CourseDto> getAllCourses() throws Exception;
    public boolean canEnroll(String student_id,String courseId) throws Exception;
    public String enrollCourse(String student_id,String courseId) throws Exception;
}
