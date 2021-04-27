package main.java.service;

import lombok.Singular;
import lombok.experimental.UtilityClass;
import main.java.dao.CountryDao;
import main.java.dto.CountryDto;
import main.java.entity.Country;

public class CountryService {

    private static final CountryService INSTANCE = new CountryService();

    private final CountryDao countryDao = CountryDao.getInstance();

    private CountryService() {}

    public CountryDto findById(String id) {
        Country country = countryDao.findById(id).orElse(null);
        return CountryDto.builder()
                .code(country.getCode())
                .description(
                        country.getName() + ", " +
                        country.getContinent() + ", " +
                        " population: " + country.getPopulation() + " peoples")
                .build();
    }

    public static CountryService getInstance() {
        return INSTANCE;
    }
}
