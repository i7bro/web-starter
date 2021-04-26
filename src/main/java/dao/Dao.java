package main.java.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K,V> {

    List<V> findALl();

    Optional<V> findById(K id);

    boolean delete(K id);

    void update(V entity);

    V save(V entity);
}
