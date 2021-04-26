package main.java.entity;

public class Country {

    private String code;
    private String name;
    private String continent;
    private Integer population;
    private String headOfState;

    public Country() {
    }

    public Country(String code, String name, String continent, Integer population, String headOfState) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.headOfState = headOfState;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getHeadIfState() {
        return headOfState;
    }

    public void setHeadIfState(String headIfState) {
        this.headOfState = headIfState;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", headOfState='" + headOfState + '\'' +
                '}';
    }
}