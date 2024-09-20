public class Cycling extends Workout implements WorkoutLog, WorkoutUpdate{
    private double cyclingPower; 
    private double cyclingSpeed; 
    private double cyclingDistance; 

    public Cycling(double duration, int caloriesBurned, int heartRate, char intensity, String feedback, String name,
                   double cyclingDistance, double cyclingPower, double cyclingSpeed) {
        super();
        this.cyclingPower = cyclingPower;
        this.cyclingSpeed = cyclingSpeed;
        this.cyclingDistance = cyclingDistance;
    }

    public double getCyclingPower() {
        return cyclingPower;
    }

    public void setCyclingPower(double cyclingPower) {
        this.cyclingPower = cyclingPower;
    }

    public double getCyclingSpeed() {
        return cyclingSpeed;
    }

    public void setCyclingSpeed(double cyclingSpeed) {
        this.cyclingSpeed = cyclingSpeed;
    }

    public double getCyclingDistance() {
        return cyclingDistance;
    }

    public void setCyclingDistance(double cyclingDistance) {
        this.cyclingDistance = cyclingDistance;
    }

    @Override
    public String toString() {
        return super.toString() + "Cycling [cyclingPower=" + cyclingPower + ", cyclingSpeed=" + cyclingSpeed + ", cyclingDistance=" + cyclingDistance + "]";
    }

    @Override
    public double calculateCalories() {
    	
        double caloriesPerMinute = (cyclingPower * 0.15) + (cyclingSpeed * 0.7); 
       
        double totalCalories = caloriesPerMinute * getDuration();

        return totalCalories;
    }
    @Override
    public void logWorkout() {
        System.out.println("Log Cycling Workout: CyclingPower: " + cyclingPower + " Watts, Distance: " + cyclingDistance + " km." + "Speed:" + cyclingSpeed + "km/h");
    }

    @Override
    public void updateWorkout() {
        System.out.println("Updating Cycling Workout: Enter new info...");
    }
}
