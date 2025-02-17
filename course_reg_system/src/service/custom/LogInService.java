package service.custom;

import dto.AdminDto;
import dto.StudentDto;
import service.SuperService;

public interface LogInService extends SuperService{
    public StudentDto searchStudent(String student_id) throws Exception;
    public AdminDto searchAdmin(String admin_id) throws Exception;
}
