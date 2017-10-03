package entityes;

import enums.Grade;
import enums.Condition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Bus {
    private String number;
    private String model;
    private Grade grade;
    private Condition condition;

    public Bus() {
    }

    public Bus(String number, String model, Grade grade, Condition condition) {
        this.number = number;
        this.model = model;
        this.grade = grade;
        this.condition = condition;
    }


}
