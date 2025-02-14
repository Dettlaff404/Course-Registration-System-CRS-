package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.CrudUtil;
import dao.custom.CourseDao;
import entity.CourseEntity;

public class CourseDaoIMPL implements CourseDao {

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM course WHERE course_id = ?", id);
    }

    @Override
    public ArrayList<CourseEntity> getAll() throws Exception {
        ArrayList<CourseEntity> courseEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM course");
        while (rst.next()) {
            courseEntities.add(new CourseEntity(
                rst.getString("course_id"), 
                rst.getString("title"), 
                rst.getInt("cred_hrs"), 
                rst.getInt("max_enrollcap"), 
                rst.getString("department_id")));        
        }
        return courseEntities;
    }

    @Override
    public boolean save(CourseEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO course VALUES(?,?,?,?,?)",
                t.getCourse_id(), 
                t.getTitle(), 
                t.getCred_hrs(), 
                t.getMax_enrollcap(), 
                t.getDepartment_id());
    }

    @Override
    public CourseEntity searchById(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM course WHERE course_id = ?", id);
        if (rst.next()) {
            return new CourseEntity(
                rst.getString("course_id"), 
                rst.getString("title"), 
                rst.getInt("cred_hrs"), 
                rst.getInt("max_enrollcap"), 
                rst.getString("department_id"));        
        }
        return null;
    }

    @Override
    public boolean update(CourseEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE course SET course_id = ?, title = ?, cred_hrs = ?, max_enrollcap = ?, department_id = ?",
                t.getCourse_id(), 
                t.getTitle(), 
                t.getCred_hrs(), 
                t.getMax_enrollcap(), 
                t.getDepartment_id());
    }
    

}
