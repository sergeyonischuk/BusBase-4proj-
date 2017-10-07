package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DriverUserDAO extends FactoryDAO implements GenericDAO {
    private Connection connection;

    public DriverUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Object object) throws SQLException {

    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    public String getDriverIdByUsername(String username) {
        String sql = "SELECT driver_id FROM driver_user WHERE user_login =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String driverID = rs.getString("driver_id");
                return driverID;
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
