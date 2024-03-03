package AnimalBase;

import java.io.Serializable;

public class Cats implements Serializable {

    private String name;
    private String home;

    public Cats(String name, String home){
        this.name = name;
        this.home = home;
    }

}
