import java.time.LocalTime;

public class Church extends Node implements Visitable {

    private LocalTime openHour;
    private LocalTime closeHour;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    Church()
    {
    }
    Church(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void setOpenHour(LocalTime openHour) {
        this.openHour = openHour;
    }

    @Override
    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    @Override
    public LocalTime getOpenHour() {
        return openHour;
    }

    @Override
    public LocalTime getCloseHour() {
        return closeHour;
    }
}
