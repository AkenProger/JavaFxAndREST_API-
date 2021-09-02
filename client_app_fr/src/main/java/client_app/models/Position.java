package client_app.models;
import lombok.Data;

@Data
public class Position {
    private Long id;
    private String name;
    private boolean active;

    @Override
    public String toString() {
        return
                 id +" /"  + name + " /"
                + active;
    }
}
