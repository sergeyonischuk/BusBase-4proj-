package services;

import DAO.UserDAO;
import entityes.User;

public class SecurityService {
    UserDAO userDAO = new UserDAO();

    public boolean checkUser(String name, String password) {
        User user = userDAO.getUserByName(name, password);
        if (user != null) {
            return true;
        }
        return false;
    }

}
