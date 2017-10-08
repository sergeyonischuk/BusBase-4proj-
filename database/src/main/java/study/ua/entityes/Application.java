package study.ua.entityes;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import study.ua.enums.Grade;
import study.ua.enums.Status;
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
