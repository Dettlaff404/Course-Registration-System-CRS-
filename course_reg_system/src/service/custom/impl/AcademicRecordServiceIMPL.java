package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.EnrollmentDao;
import dao.custom.StudentDao;
import dto.EnrollmentDto;
import dto.StudentDto;
import entity.EnrollmentEntity;
import service.custom.AcademicRecordService;

public class AcademicRecordServiceIMPL implements AcademicRecordService {

    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);
    private EnrollmentDao enrollmentDao = (EnrollmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ENROLLMENT);
    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public ArrayList<EnrollmentDto> searchCompletedCourseByStudent(String student_id) throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = enrollmentDao.searchByStudentIdCompleted(student_id);
        ArrayList<EnrollmentDto> enrollmentDtos = new ArrayList<>();

        for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
            enrollmentDtos.add(new EnrollmentDto(
                enrollmentEntity.getStudent_id(),
                studentDao.searchById(enrollmentEntity.getStudent_id()).getStudent_name(),
                enrollmentEntity.getCourse_id(),
                courseDao.searchById(enrollmentEntity.getCourse_id()).getTitle(),
                enrollmentEntity.getSemester(),
                enrollmentEntity.getGrade(),
                enrollmentEntity.getId()
            ));
        }
        return enrollmentDtos;
    }

    @Override
    public StudentDto searchStudent(String student_id) throws Exception {
        return new StudentDto(
                student_id,
                studentDao.searchById(student_id).getStudent_name(),
                studentDao.searchById(student_id).getDob(),
                studentDao.searchById(student_id).getYear(),
                studentDao.searchById(student_id).getContact(),
                studentDao.searchById(student_id).getProgram_id()
        );
    }

}
