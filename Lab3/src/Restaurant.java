public class Restaurant extends Node implements Classifiable {
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    Restaurant()
    {

    }
    Restaurant(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
