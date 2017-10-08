package study.ua.DAO;


import lombok.extern.log4j.Log4j;
import study.ua.connection.ConnectionPool;
import study.ua.entityes.Bus;
import study.ua.enums.Condition;
import study.ua.enums.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Log4j
public class BusDAO  implements GenericDAO<Bus> {
    private ConnectionPool connectionPool = ConnectionPool.getConnectionPoolInstance();

    public Bus getByID(String number) {
        String sql = "SELECT * FROM buses WHERE number =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
             {
            preparedStatement.setString(1, number);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String model = rs.getString("model");
                Grade grade = Grade.valueOf(rs.getString("grade"));
                Condition condition = Condition.valueOf(rs.getString("condition"));
                return Bus.builder()
                        .number(number)
                        .model(model)
                        .grade(grade)
                        .condition(condition)
                        .build();
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    public List<Bus> getByGrade(Grade grade) {
        return null;
    }

    public void changeCondition(String busID, Condition condition) {
        String sql = "UPDATE buses SET `condition` =? where number =?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, condition.name());
            preparedStatement.setString(2, busID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Bus object){

    }

    @Override
    public List<Bus> getAll() {
        List<Bus> busList = new ArrayList<>();
        String sql = "SELECT * FROM buses";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

             ResultSet rs = preparedStatement.executeQuery(sql);) {
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setNumber(rs.getString("number"));
                bus.setModel(rs.getString("model"));
                bus.setGrade(Grade.valueOf(rs.getString("grade")));
                bus.setCondition(Condition.valueOf(rs.getString("condition")));
                busList.add(bus);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return busList;
    }

    @Override
    public void update(Bus object){

    }

    @Override
    public void remove(Bus object){

    }
}
