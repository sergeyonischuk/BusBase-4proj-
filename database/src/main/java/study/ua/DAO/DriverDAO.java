package DAO;

import entityes.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DriverDAO extends FactoryDAO implements GenericDAO<Driver> {
    private Connection connection;

    public DriverDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Driver object){

    }

    @Override
    public List<Driver> getAll(){
        return null;
    }

    public Driver getByPasport(String id_pasport) {
        String sql = "SELECT * FROM drivers WHERE id_pasport =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ){
            preparedStatement.setString(1, id_pasport);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String pasport  = rs.getString("id_pasport");
                String name = rs.getString("name");
                String secondname = rs.getString("surname");
                return Driver.builder()
                        .pasportID(pasport)
                        .name(name)
                        .secondName(secondname)
                        .build();
            }
//            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(Driver object) {

    }

    @Override
    public void remove(Driver object) {

    }
}