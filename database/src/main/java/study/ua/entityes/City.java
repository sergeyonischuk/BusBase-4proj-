package study.ua.entityes;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Setter
@Getter
public class City {
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

}
