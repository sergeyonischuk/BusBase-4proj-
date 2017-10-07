package entityes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
