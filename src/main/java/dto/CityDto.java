package main.java.dto;


import java.util.Objects;

public class CityDto {

    private final int id;
    private final String countyCode;
    private final String description;

    public CityDto(int id, String countyCode, String description) {
        this.id = id;
        this.countyCode = countyCode;
        this.description = description;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return id == cityDto.id && Objects.equals(countyCode, cityDto.countyCode) && Objects.equals(description, cityDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countyCode, description);
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", countyCode='" + countyCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
