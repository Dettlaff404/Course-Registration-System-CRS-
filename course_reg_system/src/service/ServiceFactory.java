package service;

import service.custom.impl.AcademicRecordServiceIMPL;
import service.custom.impl.LogInServiceIMPL;
import service.custom.impl.StudentCourseSearchIMPL;
import service.custom.impl.StudentCurrentlyFollowingCoursesServiceIMPL;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case ACADEMIC_RECORD:
                return new AcademicRecordServiceIMPL();
            case LOGIN:
                return new LogInServiceIMPL();
            case STUDENT_COURSE_SEARCH:
                return new StudentCourseSearchIMPL();
            case STUDENT_CURRENTLY_FOLLOWING_COURSES:
                return new StudentCurrentlyFollowingCoursesServiceIMPL();
            default:
                return null;
        }
    }

    public enum ServiceType {
        LOGIN, ACADEMIC_RECORD, STUDENT_COURSE_SEARCH, STUDENT_CURRENTLY_FOLLOWING_COURSES,
    }

}
