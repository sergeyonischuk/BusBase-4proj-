package DAO;

import entityes.City;
import entityes.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CityDAO extends FactoryDAO implements GenericDAO<City> {

    private Connection connection;

    public CityDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(City city) {
        String sql = "INSERT INTO cities (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getAll(){
        return null;
    }

    public Route getByID(int id){
        return null;
    }

    @Override
    public void update(City object){

    }

    @Override
    public void remove(City object){

    }
}
