package study.ua.DAO;



import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Log4j
public class RouteDAO implements GenericDAO<Route> {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    @Override
    public void add(Route route) {
        String sql = "INSERT INTO routes (id, city_dispatch, city_destination) VALUES (?,?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, route.getId());
            preparedStatement.setString(2, route.getDispatchPlace());
            preparedStatement.setString(3, route.getDestinationPlace());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Route> getAll() {
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT id, city_dispatch, city_destination FROM routes";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            ResultSet rs = preparedStatement.executeQuery(sql);

            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setDispatchPlace(rs.getString("city_dispatch"));
                route.setDestinationPlace(rs.getString("city_destination"));

                routeList.add(route);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return routeList;
    }

    public Route getByID (int id) {
        String sql = "SELECT * FROM routes WHERE id =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int routeID = rs.getInt("id");
                String disp = rs.getString("city_dispatch");
                String dest = rs.getString("city_destination");
                return Route.builder()
                        .id(routeID)
                        .dispatchPlace(disp)
                        .destinationPlace(dest)
                        .build();
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public void update(Route route) {
        String sql = "UPDATE routes SET city_dispatch=?, city_destination=? WHERE id=?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, route.getDispatchPlace());
            preparedStatement.setString(2, route.getDestinationPlace());
            preparedStatement.setInt(3, route.getId());
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void remove(Route route) {
        String sql = "DELETE FROM routes WHERE id =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, route.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
    }
}
