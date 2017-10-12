package study.ua.services;

import lombok.extern.log4j.Log4j;
import study.ua.DAO.ApplicationDAO;
import study.ua.DAO.ConfirmedAppDAO;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Application;
import study.ua.enums.Status;

import java.util.List;

@Log4j
public class ApplicationService {
    private static ApplicationService instance;
    private DaoFactory daoFactory = new DaoFactory();


    public static ApplicationService getInstance() {
        if (instance == null) {
            instance = new ApplicationService();
        }
        return instance;
    }

    public int getAppIDbyDriverID(String id) {
        ConfirmedAppDAO confirmedAppDAO = daoFactory.getConfirmedAppDAO();
        return confirmedAppDAO.getApplicationIDByDriverID(id);
    }

    public Application getAppByID(int id) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        return applicationDAO.getByID(id);
    }

    public Application getApplicationByID(int appID) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        return applicationDAO.getByID(appID);
    }

    public void closeApplication(Application application) {
        ConfirmedAppDAO confirmedAppDAO = daoFactory.getConfirmedAppDAO();
        confirmedAppDAO.changeStatus(Status.CLOSED, application.getId());
        log.info("Application with ID " + application.getId() + " was closed");
    }

    public List<Application> getApplicationsWithStatus(Status status) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        return applicationDAO.getAllwithStatus(status);
    }
}