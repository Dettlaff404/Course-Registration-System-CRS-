package dao;

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
                return null;
            case STUDENT:
                return null;
            case ENROLLMENT:
                return null;
            case PREREQUISITE:
                return null;
            default:
                return null;
        }
    }

    public enum DaoTypes {
        COURSE, STUDENT, ENROLLMENT, PREREQUISITE
    }
}
