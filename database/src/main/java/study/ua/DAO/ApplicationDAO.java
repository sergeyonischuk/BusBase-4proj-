package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.Application;
import study.ua.enums.Grade;
import study.ua.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class ApplicationDAO implements GenericDAO<Application> {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

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

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, status.name());
            ResultSet rs = preparedStatement.executeQuery();
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
            log.error(e);
        }
        return null;
    }

    public Application getByID(int id) {
        String sql = "SELECT * FROM applications WHERE id =?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
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
            log.error(e);
        }
        return null;
    }

    @Override
    public void update(Application application) {

    }

    @Override
    public void remove(Application application) {

    }
}
