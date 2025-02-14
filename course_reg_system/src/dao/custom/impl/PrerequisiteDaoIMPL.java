package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.PrerequisiteDao;
import entity.PrerequisiteEntity;
import entity.StudentEntity;

public class PrerequisiteDaoIMPL implements PrerequisiteDao{

    @Override
    public boolean save(PrerequisiteEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO prerequisites VALUES(?,?)",
         t.getCourse_id(),
         t.getPrereq_id());
    }

    @Override
    public boolean update(PrerequisiteEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public PrerequisiteEntity searchById(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<PrerequisiteEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean delete(String id, String prereq_id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM prerequisites WHERE course_id = ? AND prereq_course_id = ?", id, prereq_id);
    }

    public ArrayList<PrerequisiteEntity> getPrereqs(String id) throws Exception {
        ArrayList<PrerequisiteEntity> prereqEntities = new ArrayList<>(); 
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM prerequisites WHERE course_id = ?", id);
        while (rst.next()) {
            prereqEntities.add(new PrerequisiteEntity(
                rst.getString("course_id"), 
                rst.getString("prereq_course_id")));        
        }
        return prereqEntities;
    }

}
