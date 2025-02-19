package dao.custom;

import java.util.ArrayList;

import dao.CrudDao;
import entity.EnrollmentEntity;

public interface EnrollmentDao extends CrudDao<EnrollmentEntity, String> {
    ArrayList<EnrollmentEntity> searchByStudentIdCompleted(String id) throws Exception;
    ArrayList<EnrollmentEntity> searchByStudentIdCurrentlyFollowing(String id) throws Exception;
    Boolean enrolledPreiviously(String student_id,String courseId) throws Exception;
}
