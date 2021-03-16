package DAO;

import java.util.List;

public interface DAO<T> {
    T save(T object);

    List getList();

    T update(T object);

    T delete(Long id);

    T findById(Long id);
}
