package entity;

public class Movie {
    private int id;
    private String name;
    private int director_id;
    Movie(){

    }
    Movie(int id,String name,int director_id){
        this.id=id;
        this.name=name;
        this.director_id=director_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDirector_id() {
        return director_id;
    }
}
