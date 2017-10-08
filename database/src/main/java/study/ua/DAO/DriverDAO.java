package study.ua.DAO;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import study.ua.connection.ConnectionPool;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Log4j
public class DriverDAO implements GenericDAO<Driver> {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    @Override
    public void add(Driver object){

    }

    @Override
    public List<Driver> getAll(){
        return null;
    }

    public Driver getByPasport(String id_pasport) {
        String sql = "SELECT * FROM drivers WHERE id_pasport =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

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
        } catch (SQLException e) {
            log.error(e);
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