package service.custom.impl;

import dao.DaoFactory;
import dao.custom.AdminDao;
import dao.custom.StudentDao;
import dto.AdminDto;
import dto.StudentDto;
import entity.AdminEntity;
import entity.StudentEntity;
import service.custom.LogInService;

public class LogInServiceIMPL implements LogInService {

    private AdminDao adminDao = (AdminDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ADMIN);
    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public StudentDto searchStudent(String student_id) throws Exception {
        StudentEntity studentEntity = studentDao.searchById(student_id);
        if (studentEntity != null) {
            return new StudentDto(
                    studentEntity.getStudent_id(),
                    studentEntity.getStudent_name(),
                    studentEntity.getDob(),
                    studentEntity.getDob().toString().split("-")[0],
                    studentEntity.getContact(),
                    studentEntity.getPassword(),
                    studentEntity.getProgram_id()
            );
        }
        return null;
    }

    @Override
    public AdminDto searchAdmin(String admin_id) throws Exception {
        AdminEntity adminEntity = adminDao.searchById(admin_id);
        if (adminEntity != null) {
            return new AdminDto(
                    adminEntity.getAdmin_id(),
                    adminEntity.getTitle(),
                    adminEntity.getFull_name(),
                    adminEntity.getPassword(),
                    adminEntity.getPost()
            );
        }
        return null;
    }

    @Override
    public boolean studentLogIn(String id, String password) throws Exception {
        return studentDao.searchById(id).getPassword().equals(password);
    }

    @Override
    public boolean adminLogIn(String id, String password) throws Exception {
        return adminDao.searchById(id).getPassword().equals(password);
    }

}
