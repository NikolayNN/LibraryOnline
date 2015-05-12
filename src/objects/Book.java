package objects;

import java.io.Serializable;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class Book implements Serializable {
    private String name;



    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
