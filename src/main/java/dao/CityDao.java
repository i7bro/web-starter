package main.java.dao;

import main.java.entity.City;
import main.java.exception.DaoException;
import main.java.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDao implements Dao<Integer, City> {

    private static CityDao INSTANCE = new CityDao();
    private CountryDao countryDao = CountryDao.getInstance();
    private static final String FIND_ALL_SQL =
            "select * from city order by countrycode, name";

    private CityDao() {}

    public static CityDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<City> findALl() {
        try (Connection connection = ConnectionUtil.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = statement.executeQuery();
            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(buildCity(resultSet));
            }

            return cities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    private City buildCity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getInt("id"),
                resultSet.getString("countryCode"),
                resultSet.getString("district"),
                resultSet.getString("name"),
                resultSet.getInt("population")
        );
    }

    @Override
    public Optional<City> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public City save(City entity) {
        return null;
    }
}
