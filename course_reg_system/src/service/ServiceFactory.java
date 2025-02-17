package service;

import service.custom.impl.LogInServiceIMPL;

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
            case FACULTY,STAFF:
                return null;
            case STUDENT:
                return null;
            case LOGIN:
                return new LogInServiceIMPL();
            default:
                return null;
        }
    }

    public enum ServiceType {
        STUDENT, FACULTY, STAFF, LOGIN
    }

}
