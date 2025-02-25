package service.custom;

import java.util.ArrayList;

import dto.CourseDto;
import dto.EnrollmentDto;
import service.SuperService;

public interface Admin_CoursePanelService extends SuperService{
    public ArrayList<CourseDto> getAllCourses() throws Exception;
    public boolean saveCourse(CourseDto courseDto) throws Exception;
    public boolean deleteCourse(String courseId) throws Exception;
    public ArrayList<EnrollmentDto> getEnrollmentsToBeGraded(String courseId) throws Exception;
    public ArrayList<EnrollmentDto> getCompletedEnrollments(String courseId) throws Exception;
    public boolean gradeEnrollment(Integer enrollmentId, Character grade) throws Exception;
    public boolean deleteEnrollment(Integer enrollmentId) throws Exception;
    public CourseDto searchCourse(String courseId) throws Exception;
}
