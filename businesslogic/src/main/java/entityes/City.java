package entityes;

import lombok.Getter;
import lombok.Setter;

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
