package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.PrerequisiteEntity;

public interface PrerequisiteDao extends CrudDao<PrerequisiteEntity, String>{

    boolean delete(String id, String prereq_id) throws Exception;
    public ArrayList<PrerequisiteEntity> getPrereqs(String id) throws Exception;

}
