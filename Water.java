import java.time.LocalDateTime;
import java.util.ArrayList;
public class Water {
    private double waterAmount;  
    private LocalDateTime intakeDateTime;
    private static ArrayList<Water> water;


    public Water() {
        water = new ArrayList<>();
    }

    public Water(double waterAmount) {
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

    
    // A water object is added to the list
    public static void logWaterIntake(Water waters) {
        water.add(waters);
        System.out.println("Workout added at " + waters.getIntakeDateTime());
    }

    public static ArrayList<Water> getWater() {
        return water;
    }
}
