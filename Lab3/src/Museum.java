import java.time.Duration;
import java.time.LocalTime;

public class Museum extends Node implements Payable,Visitable {
    private LocalTime openHour;
    private LocalTime closeHour;
    public void setName(String name) {
        this.name = name;
    }
    Museum(){}
    Museum(String name)
    {
        this.name=name;
    }

    @Override
    public void setOpenHour(LocalTime openHour) {
        this.openHour=openHour;
    }

    @Override
    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }
    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public void setPrice(double price) {
        this.price=price;
    }
}
