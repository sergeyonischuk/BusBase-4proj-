package study.ua.entityes;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@Builder
public class Driver{

    private String name;
    private String secondName;
    private String pasportID;
    private Bus bus;
}
