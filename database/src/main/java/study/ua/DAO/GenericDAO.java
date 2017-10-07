package DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T>{
    void add(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    void update(T object) throws SQLException;
    void remove(T object) throws SQLException;
}
