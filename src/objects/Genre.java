package objects;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class Genre {
    private String name;
    private int id;

    public Genre(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }
}
