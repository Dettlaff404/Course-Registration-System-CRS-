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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStudent'");
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
