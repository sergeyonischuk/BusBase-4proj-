package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log4j
public class DriverUserDAO implements GenericDAO {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    @Override
    public void add(Object object) throws SQLException {

    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    public String getDriverIdByUsername(String username) {
        String sql = "SELECT driver_id FROM driver_user WHERE user_login =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("driver_id");
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Object object) throws SQLException {

    }

    @Override
    public void remove(Object object) throws SQLException {

    }
}
