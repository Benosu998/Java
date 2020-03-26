
import java.time.Duration;
import java.time.LocalTime;



public interface Visitable {
    void setOpenHour(LocalTime openHour);
    void setCloseHour(LocalTime closeHour);
    LocalTime getOpenHour();
    LocalTime getCloseHour();
    default void setHour()
    {
        this.setOpenHour(LocalTime.of(9,30));
        this.setCloseHour(LocalTime.of(20,0));
    }
    static Duration getVisitingDuration(LocalTime openHour, LocalTime closeHour)
    {
        return Duration.between(openHour,closeHour);
    }
    
}
