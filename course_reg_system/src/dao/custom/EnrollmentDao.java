package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.EnrollmentEntity;

public interface EnrollmentDao extends CrudDao<EnrollmentEntity, String> {
    ArrayList<EnrollmentEntity> searchByStudentId(String id) throws Exception;

}
