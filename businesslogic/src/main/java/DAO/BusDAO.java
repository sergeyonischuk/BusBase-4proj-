package DAO;


import entityes.Bus;
import enums.Condition;
import enums.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BusDAO extends FactoryDAO implements GenericDAO<Bus> {
    private Connection connection;

    public BusDAO(Connection connection) {
        this.connection = connection;
    }

    public Bus getByID(String number){
        String sql = "SELECT * FROM buses WHERE number =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);)
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
            e.printStackTrace();
        }
        return null;
    }

    public List<Bus> getByGrade(Grade grade) {
        return null;
    }

    public void changeConditionToBroken(String busID) {
        String sql = "UPDATE buses SET condition = REPAIR_NEEDED where number =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, busID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Bus object){

    }

    @Override
    public List<Bus> getAll(){
        return null;
    }


    @Override
    public void update(Bus object){

    }

    @Override
    public void remove(Bus object){

    }
}
