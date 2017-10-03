package DAO;

import entityes.Application;
import entityes.Driver;
import enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConfirmedAppDAO extends UtilConn {


    public void add(Application app, Driver driver) {
        String sql = "INSERT INTO confirmed_applications (application_id, driver_id) VALUES (?,?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, app.getId());
            preparedStatement.setString(2, driver.getPasportID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeStatus(Status status, int appID){
        String sql = "UPDATE applications SET status =? WHERE id =?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, status.name());
            preparedStatement.setInt(2, appID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Application getApplicationByDriverID(String driverID) {
        String sql = "SELECT * FROM applications WHERE driver_id = ?";
        //app must have "open" status.
        return null;
    }

}
