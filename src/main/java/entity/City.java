package main.java.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class City {

    private int id;
    private String countryCode; //сюда переается сразу сущность Country
    private String district;
    private String name;
    private int population;
}
