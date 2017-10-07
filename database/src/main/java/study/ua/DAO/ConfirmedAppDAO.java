package DAO;

import entityes.Application;
import entityes.Driver;
import enums.Grade;
import enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmedAppDAO extends FactoryDAO {
    private Connection connection;

    public ConfirmedAppDAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Application app, Driver driver) {
        String sql = "INSERT INTO confirmed_applications (application_id, driver_id) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, app.getId());
            preparedStatement.setString(2, driver.getPasportID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeStatus(Status status, int appID){
        String sql = "UPDATE applications SET status =? WHERE id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, status.name());
            preparedStatement.setInt(2, appID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getApplicationIDByDriverID(String driverID) {
        String sql = "SELECT application_id FROM confirmed_applications WHERE driver_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1, driverID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int appID  = rs.getInt("application_id");

                return appID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
