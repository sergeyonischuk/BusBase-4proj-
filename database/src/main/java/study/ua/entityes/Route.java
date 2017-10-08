package study.ua.entityes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@Builder
public class Route {
    private int id;
    private String dispatchPlace;
    private String destinationPlace;

    public Route() {
    }

    public Route(int id, String dispatchPlace, String destinationPlace) {
        this.id = id;
        this.dispatchPlace = dispatchPlace;
        this.destinationPlace = destinationPlace;
    }
}
