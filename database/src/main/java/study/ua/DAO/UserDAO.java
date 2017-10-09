package study.ua.DAO;


import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.User;
import study.ua.enums.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Log4j
public class UserDAO implements GenericDAO{
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    public UserType getUserType(String login) {
        UserType type = null;
        String sql = "SELECT type FROM users WHERE login=?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, login);
            if (preparedStatement.execute()) {
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                type = UserType.valueOf(rs.getString("type").toUpperCase());
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return type;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public List getAll() {
        return null;
    }

    public User getUserByName(String login) {
        String sql = "SELECT * FROM users WHERE login=?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String pas = rs.getString("password");
                UserType type = UserType.valueOf(rs.getString("type"));
                return User.builder()
                        .login(login)
                        .password(pas)
                        .type(type)
                        .build();
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    public boolean checkUserByPassword(String login, String password) {
        String sql = "SELECT * FROM users WHERE login=? AND password=?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
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
            log.error(e);
        }
        return false;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void remove(Object object) {

    }
}
