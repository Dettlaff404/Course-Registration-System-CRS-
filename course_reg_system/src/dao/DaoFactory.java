package dao;

import dao.custom.impl.AdminDaoIMPL;
import dao.custom.impl.CourseDaoIMPL;
import dao.custom.impl.EnrollmentDaoIMPL;
import dao.custom.impl.PrerequisiteDaoIMPL;
import dao.custom.impl.StudentDaoIMPL;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case COURSE:
                return new CourseDaoIMPL();
            case STUDENT:
                return new StudentDaoIMPL();
            case ADMIN:
                return new AdminDaoIMPL();
            case ENROLLMENT:
                return new EnrollmentDaoIMPL();
            case PREREQUISITE:
                return new PrerequisiteDaoIMPL();
            default:
                return null;
        }
    }

    public enum DaoTypes {
        COURSE, STUDENT, ENROLLMENT, PREREQUISITE, ADMIN
    }
}
