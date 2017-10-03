package entityes;

import enums.Grade;
import enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Application {
    private int id;
    private int routeID;
    private Grade grade;
    private Status status;

    public Application(int id, int routeID, Grade grade, Status status) {
        this.id = id;
        this.routeID = routeID;
        this.grade = grade;
        this.status = status;
    }

}
