package main.java.service;

import main.java.dao.CountryDao;
import main.java.dto.CountryDto;
import main.java.entity.Country;

import java.util.List;

public class CountryService {

    private static final CountryService INSTANCE = new CountryService();

    private final CountryDao countryDao = CountryDao.getInstance();

    public CountryDto findById(String id) {
        Country country = countryDao.findById(id).orElse(null);
        return new CountryDto(country.getCode(),
                country.getName() + ", " +
                        country.getContinent() + ", " +
                        " population: " + country.getPopulation() + " peoples");
    }

    private CountryService() {
    }

    public static CountryService getInstance() {
        return INSTANCE;
    }
}
