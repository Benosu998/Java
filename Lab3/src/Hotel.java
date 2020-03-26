public class Hotel extends Node implements Classifiable {
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    Hotel()
    {

    }
    Hotel(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

