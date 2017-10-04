package services;

import DAO.FactoryDAO;
import DAO.UserDAO;
import entityes.User;

public class SecurityService {
    UserDAO userDAO = new FactoryDAO().getUserDAO();


    public boolean validateUser(String name, String password) {
        if(userDAO.checkUserByPassword(name, password)){
            return true;
        }
        return false;
    }

}
