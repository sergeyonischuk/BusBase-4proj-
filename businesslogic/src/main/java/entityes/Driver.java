package entityes;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Driver{

    private String name;
    private String secondName;
    private String pasportID;
    private String password;
    private Bus bus;
}
