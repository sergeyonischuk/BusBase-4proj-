package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.Application;
import study.ua.entityes.Driver;
import study.ua.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class ConfirmedAppDAO {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    public void add(Application app, Driver driver) {
        String sql = "INSERT INTO confirmed_applications (application_id, driver_id) VALUES (?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, app.getId());
            preparedStatement.setString(2, driver.getPasportID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public void changeStatus(Status status, int appID) {
        String sql = "UPDATE applications SET status =? WHERE id =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, status.name());
            preparedStatement.setInt(2, appID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public int getApplicationIDByDriverID(String driverID) {
        String sql = "SELECT application_id FROM confirmed_applications WHERE driver_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, driverID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("application_id");
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return -1;
    }
}
