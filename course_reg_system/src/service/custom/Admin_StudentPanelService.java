package service.custom;

import java.util.ArrayList;

import dto.StudentDto;
import service.SuperService;

public interface Admin_StudentPanelService extends SuperService{
    boolean saveStudent(StudentDto studentDto, String password) throws Exception;
    boolean deleteStudent(String student_id) throws Exception;
    ArrayList<StudentDto> getAllStudents() throws Exception;
}
