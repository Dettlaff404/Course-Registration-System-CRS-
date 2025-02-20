package service.custom;

import java.util.ArrayList;
import dto.EnrollmentDto;
import service.SuperService;

public interface StudentCurrentlyFollowingCoursesService extends SuperService {
    ArrayList<EnrollmentDto> searchCurrentlyFollowingCourses(String student_id) throws Exception;
    Boolean dropCourse(int id) throws Exception;
    Boolean canDropCourse(int id) throws Exception;
}
