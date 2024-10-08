public class Cycling extends Workout implements WorkoutUpdater{
    private double cyclingPower; 
    private double cyclingSpeed; 
    private double cyclingDistance; 

    public Cycling(double duration, int heartRate, char intensity,
                   double cyclingDistance, double cyclingPower, double cyclingSpeed) {
        super(duration, heartRate, intensity);
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
    	
        double caloriesPerMinute = (cyclingPower * 0.06) + (cyclingSpeed * 0.2); 
       
        double totalCalories = caloriesPerMinute * getDuration();

        return totalCalories;
    }

    @Override
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
        switch (attribute.toLowerCase()) {
            case "cyclingpower":
                this.cyclingPower = (double) newValue;
                break;
            case "cyclingspeed":
                this.cyclingSpeed = (double) newValue;
                break;
            case "cyclingdistance":
                this.cyclingDistance = (double) newValue;
                break;
                case "duration":
				setDuration((double) newValue); 
				break;
			case "caloriesburned":
				setCaloriesBurned((int) newValue); 
				break;
			case "heartrate":
				setHeartRate((int) newValue); 
				break;
			case "intensity":
				setIntensity((char) newValue); 
				break;
            default:
            throw new InvalidAttributeException("Invalid attribute for this workout: " + attribute);
        }
        System.out.println("Cycling workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return super.getWorkoutDetails()+ "Cycling Power: " + getCyclingPower() + ", Cycling Speed: " + getCyclingSpeed() + ", Cycling Distance: " + getCyclingDistance();
    }
}
