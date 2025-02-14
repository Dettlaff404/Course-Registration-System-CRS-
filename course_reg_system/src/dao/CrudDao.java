package dao;

import java.util.ArrayList;

public interface CrudDao<T, ID> extends SuperDao {
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(ID id) throws Exception;
    boolean delete(ID id, ID id2) throws Exception;
    T searchById(ID id) throws Exception;
    ArrayList<T> getAll() throws Exception;
}
