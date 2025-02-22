package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.StudentDao;
import dto.StudentDto;
import entity.StudentEntity;
import service.custom.Admin_StudentPanelService;

public class Admin_StudentPanelServiceIMPL implements Admin_StudentPanelService {

    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDto studentDto, String password) throws Exception {
        StudentEntity studentEntity = studentDao.searchById(studentDto.getStudent_id());
        if (studentEntity == null) {
            return studentDao.save(new StudentEntity(
                    studentDto.getStudent_id(),
                    studentDto.getStudent_name(),
                    studentDto.getDob(),
                    studentDto.getYear(),
                    studentDto.getContact(),
                    password,
                    studentDto.getProgram_id()
            ));
        } else {
            return studentDao.update(new StudentEntity(
                    studentDto.getStudent_id(),
                    studentDto.getStudent_name(),
                    studentDto.getDob(),
                    studentDto.getYear(),
                    studentDto.getContact(),
                    password.equals("123456") ? studentEntity.getPassword() : password,
                    studentDto.getProgram_id()
            ));
        }
    }

    @Override
    public boolean deleteStudent(String student_id) throws Exception {
        return studentDao.delete(student_id);
    }

    @Override
    public ArrayList<StudentDto> getAllStudents() throws Exception {
        ArrayList<StudentEntity> studentEntities = studentDao.getAll();
        ArrayList<StudentDto> studentDtos = new ArrayList<>();

        for (StudentEntity studentEntity : studentEntities) {
            studentDtos.add(new StudentDto(
                    studentEntity.getStudent_id(),
                    studentEntity.getStudent_name(),
                    studentEntity.getDob(),
                    studentEntity.getYear(),
                    studentEntity.getContact(),
                    studentEntity.getProgram_id()
            ));
        }
        return studentDtos;
    }

}
