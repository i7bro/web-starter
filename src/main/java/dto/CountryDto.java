package main.java.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CountryDto {

    String code;
    String description;
}
