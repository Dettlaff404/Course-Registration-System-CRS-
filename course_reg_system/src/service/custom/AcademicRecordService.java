package service.custom;

import java.util.ArrayList;

import dto.EnrollmentDto;
import dto.StudentDto;
import service.SuperService;

public interface AcademicRecordService extends SuperService {
    public ArrayList<EnrollmentDto> searchCompletedCourseByStudent(String student_id) throws Exception;
    public StudentDto searchStudent(String student_id) throws Exception; 
}
