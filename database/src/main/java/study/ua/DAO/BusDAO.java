package DAO;


import entityes.Bus;
import entityes.Route;
import enums.Condition;
import enums.Grade;

import java.sql.*;
import java.util.ArrayList;
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
        List<Bus> busList = new ArrayList<>();
        String sql = "SELECT * FROM buses";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);) {

            while (rs.next()) {
                Bus bus = new Bus();
                bus.setNumber(rs.getString("number"));
                bus.setModel(rs.getString("model"));
                bus.setGrade(Grade.valueOf(rs.getString("grade")));
                bus.setCondition(Condition.valueOf(rs.getString("condition")));
                busList.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
