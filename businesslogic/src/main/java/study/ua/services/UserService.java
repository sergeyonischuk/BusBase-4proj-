package study.ua.services;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import study.ua.connection.DaoFactory;
import study.ua.DAO.UserDAO;
import study.ua.entityes.User;
import study.ua.enums.UserType;
@Log4j
public class SecurityService {
    private DaoFactory daoFactory = new DaoFactory();

    public boolean validateUser(String name, String password) {
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.checkUserByPassword(name, password);
    }

    public UserType getUserType (String login) {
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.getUserType(login);
    }

    public User getUserByLogin(String login) {
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.getUserByName(login);
    }
}
