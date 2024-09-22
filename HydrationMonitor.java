import java.time.LocalDateTime;
import java.util.ArrayList;
public class HydrationMonitor {
    private double waterAmount;  
    private LocalDateTime intakeDateTime;
    private static ArrayList<HydrationMonitor> water;


    public HydrationMonitor() {
        water = new ArrayList<>();
    }

    public HydrationMonitor(double waterAmount) {
        this.waterAmount = waterAmount;
        this.intakeDateTime = LocalDateTime.now();
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public LocalDateTime getIntakeDateTime() {
        return intakeDateTime;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    
    // By adding the instance to the static list, the static method logs the amount of water consumed.
    public static void logWaterIntake(HydrationMonitor waters) {
        water.add(waters);
    }
    // Get all water intake logs list.
    public static ArrayList<HydrationMonitor> getWater() {
        return water;
    }
}
