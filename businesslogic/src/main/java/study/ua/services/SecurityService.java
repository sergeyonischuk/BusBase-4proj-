package services;

import DAO.FactoryDAO;
import DAO.UserDAO;

public class SecurityService {
    private UserDAO userDAO = new FactoryDAO().getUserDAO();

    public boolean validateUser(String name, String password) {
        return userDAO.checkUserByPassword(name, password);
    }

}
