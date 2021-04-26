package main.java.dto;

import main.java.dao.CountryDao;
import main.java.entity.Country;

import java.util.Objects;

public class CountryDto {

    private final String code;
    private final String description;

    public CountryDto(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
