package study.ua.entityes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class City {
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

}
