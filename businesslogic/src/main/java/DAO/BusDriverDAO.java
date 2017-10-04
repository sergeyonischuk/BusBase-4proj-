package DAO;

import entityes.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDriverDAO extends FactoryDAO {
    private Connection connection;

    public BusDriverDAO(Connection connection) {
        this.connection = connection;
    }


    public String getBusNumberByDriverID(String passport) {
        String sql = "SELECT bus_id FROM driver_bus WHERE driver_id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, passport);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String busID = rs.getString("bus_id");
                return busID;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Driver getDriverIdByBusNumber(String busNumber) {
        return null;
    }
}
