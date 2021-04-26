package main.java.dao;

import main.java.entity.Country;
import main.java.exception.DaoException;
import main.java.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<String, Country> {

    private static final CountryDao INSTANCE = new CountryDao();

    private CountryDao() {}

    public static CountryDao getInstance() {
        return INSTANCE;
    }

    private static final String FIND_ALL_SQL =
            "select * from country";
    private static final String FIND_BY_ID = FIND_ALL_SQL + " where code = ?";

    @Override
    public List<Country> findALl() {
        try (Connection connection = ConnectionUtil.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = statement.executeQuery();
            List<Country> list = new ArrayList<>();

            while (resultSet.next()) {
                list.add(buildCountry(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Country buildCountry(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getString("code"),
                resultSet.getString("name"),
                resultSet.getString("continent"),
                resultSet.getInt("population"),
                resultSet.getString("headOfState")
        );
    }

    @Override
    public Optional<Country> findById(String id) {
        try (Connection connection = ConnectionUtil.get();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? Optional.of(buildCountry(resultSet)) : Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void update(Country entity) {

    }

    @Override
    public Country save(Country entity) {
        return null;
    }
}
