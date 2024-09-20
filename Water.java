import java.time.LocalDateTime;
public class Water {
    private double waterAmount;  
    private LocalDateTime intakeDateTime;

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

    public void logWaterIntake() {
        System.out.println("Water intake logged: " + waterAmount + " liters on " + intakeDateTime);
    }
}
