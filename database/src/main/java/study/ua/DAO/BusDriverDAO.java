package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class BusDriverDAO {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    public String getBusNumberByDriverID(String passport) {
        String sql = "SELECT bus_id FROM driver_bus WHERE driver_id =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, passport);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("bus_id");
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    public String getDriverIdByBusNumber(String busNumber) {
        String sql = "SELECT driver_id FROM driver_bus WHERE bus_id =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, busNumber);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("driver_id");
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
}
