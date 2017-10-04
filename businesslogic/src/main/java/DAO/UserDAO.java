package DAO;


import entityes.User;
import entityes.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements GenericDAO{
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserType getUserType(String login, String password) {
        UserType type = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT type FROM users WHERE login=? AND password=?")) {
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

    public boolean checkUserByPassword(String login, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE login=? AND password=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String usr = rs.getString("login");
                String pas = rs.getString("password");
                if (usr.equals(login) && pas.equals(password)) {
                    return  true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(Object object) throws SQLException {

    }

    @Override
    public void remove(Object object) throws SQLException {

    }
}
