package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.StudentEntity;

public class StudentDaoIMPL implements StudentDao {

    @Override
    public boolean save(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES(?,?,?,?,?,?,?)",
                t.getStudent_id(), 
                t.getStudent_name(), 
                t.getDob(), 
                t.getYear(), 
                t.getContact(), 
                t.getPassword(), 
                t.getProgram_id());
    }

    @Override
    public boolean update(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE student SET name = ?, dob = ?, year = ?, contact = ?, password = ?, program_id = ? WHERE student_id = ?",
                t.getStudent_name(), 
                t.getDob(), 
                t.getYear(), 
                t.getContact(), 
                t.getPassword(), 
                t.getProgram_id(), 
                t.getStudent_id());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE student_id = ?", id);
    }

    @Override
    public StudentEntity searchById(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student WHERE student_id = ?", id);
        if (rst.next()) {
            return new StudentEntity(
                rst.getString("student_id"), 
                rst.getString("name"), 
                rst.getString("dob"), 
                rst.getString("year").split("-")[0], 
                rst.getString("contact"), 
                rst.getString("password"), 
                rst.getString("program_id"));       
        }
        return null;
    }

    @Override
    public ArrayList<StudentEntity> getAll() throws Exception {
        ArrayList<StudentEntity> studentEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student");
        while (rst.next()) {
            studentEntities.add(new StudentEntity(
                rst.getString("student_id"), 
                rst.getString("name"), 
                rst.getString("dob"), 
                rst.getString("year").split("-")[0], 
                rst.getString("contact"), 
                rst.getString("password"), 
                rst.getString("program_id")));        
        }
        return studentEntities;
    }
}
