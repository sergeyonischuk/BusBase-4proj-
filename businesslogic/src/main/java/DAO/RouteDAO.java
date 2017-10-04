package DAO;

import entityes.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends FactoryDAO implements GenericDAO<Route> {
    private Connection connection;

    public RouteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Route route) {
        String sql = "INSERT INTO routes (id, city_dispatch, city_destination) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, route.getId());
            preparedStatement.setString(2, route.getDispatchPlace());
            preparedStatement.setString(3, route.getDestinationPlace());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Route> getAll(){
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT id, city_dispatch, city_destination FROM routes";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);) {

            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setDispatchPlace(rs.getString("city_dispatch"));
                route.setDestinationPlace(rs.getString("city_destination"));

                routeList.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routeList;
    }

    public Route getByID(int id){
        String sql = "SELECT * FROM routes WHERE id =?";
        Route route = new Route();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();){

            preparedStatement.setInt(1, id);

            route.setId(rs.getInt("id"));
            route.setDispatchPlace(rs.getString("city_dispatch"));
            route.setDestinationPlace(rs.getString("city_destination"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public void update(Route route){
        String sql = "UPDATE routes SET city_dispatch=?, city_destination=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, route.getDispatchPlace());
            preparedStatement.setString(2, route.getDestinationPlace());
            preparedStatement.setInt(3, route.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Route route) {
        String sql = "DELETE FROM routes WHERE id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, route.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
