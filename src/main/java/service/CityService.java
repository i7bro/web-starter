package main.java.service;

import main.java.dao.CityDao;
import main.java.dto.CityDto;

import java.util.List;
import java.util.stream.Collectors;

public class CityService {

    private static final CityService INSTANCE = new CityService();
    private final CityDao cityDao = CityDao.getInstance();

    private CityService() {
    }

    public List<CityDto> findAll() {
        return cityDao.findALl().stream()
                .map(city -> new CityDto(
                        city.getId(),
                        city.getCountryCode(),
                        String.format("%s",
                                city.getName())))
                .collect(Collectors.toList());
    }

    public static CityService getInstance() {
        return INSTANCE;
    }
}
