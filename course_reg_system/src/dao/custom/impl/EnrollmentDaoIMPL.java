package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.EnrollmentDao;
import entity.EnrollmentEntity;

public class EnrollmentDaoIMPL implements EnrollmentDao {

    @Override
    public boolean save(EnrollmentEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO enrollments VALUES(?,?,?,?,?)",
            t.getStudent_id(),
            t.getCourse_id(),
            t.getSemester(),
            String.valueOf(t.getGrade()),
            t.getEnrolled_date());
    }

    @Override
    public boolean update(EnrollmentEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE enrollments SET semester=?, grade=?, enrolled_date = ?  WHERE id = ?",
                t.getSemester(),
                String.valueOf(t.getGrade()),
                t.getEnrolled_date(),
                t.getId());
    }

    @Override
    public ArrayList<EnrollmentEntity> getAll() throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM enrollments");
        while (rst.next()) {            
            enrollmentEntities.add(new EnrollmentEntity(
                rst.getString("student_id"),
                rst.getString("course_id"),
                rst.getString("semester"),
                rst.getString("grade").charAt(0),
                rst.getString("enrolled_date"),
                rst.getInt("id")
            ));
        }
        return enrollmentEntities;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE from enrollments WHERE id = ?", id);
    }

    @Override
    public EnrollmentEntity searchById(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM enrollments WHERE id = ?", id);
        if(rst.next()){
            return new EnrollmentEntity(
                rst.getString("student_id"),
                rst.getString("course_id"),
                rst.getString("semester"),
                rst.getString("grade").charAt(0),
                rst.getString("enrolled_date"),
                rst.getInt("id")
            );
        }
        return null;
    }

    @Override
    public ArrayList<EnrollmentEntity> searchByStudentIdCompleted(String id) throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM enrollments WHERE student_id = ? AND NOT(grade = '')", id);
        while (rst.next()) {            
            enrollmentEntities.add(new EnrollmentEntity(
                rst.getString("student_id"),
                rst.getString("course_id"),
                rst.getString("semester"),
                rst.getString("grade").charAt(0),
                rst.getString("enrolled_date"),
                rst.getInt("id")
            ));
        }
        return enrollmentEntities;
    }

    @Override
    public ArrayList<EnrollmentEntity> searchByStudentIdCurrentlyFollowing(String id) throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM enrollments WHERE student_id = ? AND grade = ''", id);
        while (rst.next()) {            
            enrollmentEntities.add(new EnrollmentEntity(
                rst.getString("student_id"),
                rst.getString("course_id"),
                rst.getString("semester"),
                null,
                rst.getString("enrolled_date"),
                rst.getInt("id")
            ));
        }
        return enrollmentEntities;
    }

}
