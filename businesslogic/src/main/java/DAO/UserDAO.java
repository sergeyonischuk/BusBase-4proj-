package DAO;


import entityes.User;
import entityes.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends UtilConn implements GenericDAO{
    private Connection connection = getConnection();

    public UserType getUserType(String login, String password) {
        UserType type = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT type FROM user" +
                " WHERE login=? AND password=?")) {
            statement.setString(1, login);
            statement.setString(2, password);
            if (statement.execute()) {
                ResultSet rs = statement.executeQuery();
                rs.next();
                type = UserType.valueOf(rs.getString("type").toUpperCase());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public void add(Object object) throws SQLException {

    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    public User getUserByName(String username, String password) {
        return null;
    }

    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public void update(Object object) throws SQLException {

    }

    @Override
    public void remove(Object object) throws SQLException {

    }
}
