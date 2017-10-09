package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.City;
import study.ua.entityes.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Log4j
public class CityDAO implements GenericDAO<City> {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    @Override
    public void add(City city) {
        String sql = "INSERT INTO cities (name) VALUES (?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<City> getAll() {
        return null;
    }

    public Route getByID(int id) {
        return null;
    }

    @Override
    public void update(City object) {

    }

    @Override
    public void remove(City object) {

    }
}
