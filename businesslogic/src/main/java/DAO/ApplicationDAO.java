package DAO;

import entityes.Application;
import enums.Grade;
import enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO extends FactoryDAO implements GenericDAO<Application> {

    private Connection connection;

    public ApplicationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Application object) {

    }

    @Override
    public List<Application> getAll() {
        return null;
    }

    public List<Application> getAllwithStatus(Status status) {
        List<Application> applications = new ArrayList<>();

        String sql = "SELECT * FROM applications WHERE status =?";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ) {
            statement.setString(1, status.name());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                applications.add(Application.builder()
                        .id(rs.getInt("id"))
                        .routeID(rs.getInt("route_id"))
                        .grade(Grade.valueOf(rs.getString("grade")))
                        .status(Status.valueOf(rs.getString("status")))
                        .build());

            }
            return applications;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Application getByID(int id) {
        String sql = "SELECT * FROM applications WHERE id =?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                int routeID = rs.getInt("route_id");
                Grade grade = Grade.valueOf(rs.getString("Grade"));
                Status status = Status.valueOf(rs.getString("Status"));
                return Application.builder()
                        .id(id)
                        .routeID(routeID)
                        .grade(grade)
                        .status(status)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Application application) {

    }

//    public void upgradeStatus(Status status, Application application) {
//        String sql = "UPDATE applications SET status=? WHERE id =?";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//
//            preparedStatement.setString(1, status.name());
//            preparedStatement.setInt(2, application.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void remove(Application application){

    }
}
