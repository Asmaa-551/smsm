public class Swimming extends Workout implements WorkoutUpdater {
    private double underwaterDepth;
    private String swimwingStyle;
    private int laps;

    public Swimming(double duration, int caloriesBurned, int heartRate, char intensity, String feedback, String name,
                    double underwaterDepth, String swimwingStyle, int laps) {
        super(); 
        this.underwaterDepth = underwaterDepth;
        this.swimwingStyle = swimwingStyle;
        this.laps = laps;
    }

    public double getUnderwaterDepth() {
        return underwaterDepth;
    }

    public void setUnderwaterDepth(double underwaterDepth) {
        this.underwaterDepth = underwaterDepth;
    }

    public String getSwimwingStyle() {
        return swimwingStyle;
    }

    public void setSwimwingStyle(String swimwingStyle) {
        this.swimwingStyle = swimwingStyle;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return super.toString() + " Swim [underwaterDepth=" + underwaterDepth + ", swimwingStyle=" + swimwingStyle + ", laps=" + laps + "]";
    }

    private double calculateCaloriesPerMinute() {
        switch (swimwingStyle.toLowerCase()) {
            case "freestyle":
                return 15; 
            case "breaststroke":
                return 9;  
            case "backstroke":
                return 6;  
            case "butterfly":
                return 18;
            default:
                throw new IllegalArgumentException("Unknown swimming style: " + swimwingStyle);
        }
    }

    @Override
    public double calculateCalories() {
        double caloriesPerMinute = calculateCaloriesPerMinute();
        if (underwaterDepth > 2) {
            caloriesPerMinute *= 1.2; 
        }
        double totalCalories = caloriesPerMinute * getDuration() * (laps / 10.0);
        return totalCalories;
    }

    @Override
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
        switch (attribute.toLowerCase()) {
            case "underwaterdepth":
                this.underwaterDepth = (double) newValue;
                break;
            case "swimmingstyle":
                this.swimwingStyle = (String) newValue;
                break;
            case "laps":
                this.laps = (int) newValue;
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
            throw new InvalidAttributeException("Invalid attribute for this  workout: " + attribute);
        }
        System.out.println("Swimming workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return "Underwater Depth: " + getUnderwaterDepth() + ", Swimwing Style: " + getSwimwingStyle() + ", Laps: " + getLaps();
    }
}
