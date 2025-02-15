package service;

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

    public SuperService getSuperService(RoleType type) {
        switch (type) {
            case FACULTY,STAFF:
                return null;
            case STUDENT:
                return null;
            default:
                return null;
        }
    }

    public enum ServiceType {
           
    }

    public enum RoleType {
        FACULTY,STAFF,STUDENT
    }

}
