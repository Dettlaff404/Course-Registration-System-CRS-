package service.custom.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.EnrollmentDao;
import dto.EnrollmentDto;
import entity.EnrollmentEntity;
import service.custom.StudentCurrentlyFollowingCoursesService;

public class StudentCurrentlyFollowingCoursesServiceIMPL implements StudentCurrentlyFollowingCoursesService {

    private EnrollmentDao enrollmentDao = (EnrollmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ENROLLMENT);
    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);
    
    @Override
    public ArrayList<EnrollmentDto> searchCurrentlyFollowingCourses(String student_id) throws Exception {
        ArrayList<EnrollmentEntity> enrollmentEntities = enrollmentDao.searchByStudentIdCurrentlyFollowing(student_id);
        ArrayList<EnrollmentDto> enrollmentDtos = new ArrayList<>();

        for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
            enrollmentDtos.add(new EnrollmentDto(
                enrollmentEntity.getStudent_id(),
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
    public Boolean dropCourse(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dropCourse'");
    }

    @Override
    public Boolean canDropCourse(int id) throws Exception {

        EnrollmentEntity enrollmentEntity = enrollmentDao.searchByIdInt(id);

        LocalDate enrolledDate = LocalDate.parse(enrollmentEntity.getEnrolled_date(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(enrolledDate, currentDate);

        return daysBetween <= 14;

    }

    

}
