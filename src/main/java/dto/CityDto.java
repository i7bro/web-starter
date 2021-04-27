package main.java.dto;
import lombok.*;


@Value
@Builder
public class CityDto {

    int id;
    String countyCode;
    String description;
}
