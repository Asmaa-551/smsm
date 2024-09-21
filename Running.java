public class Running extends Workout implements WorkoutUpdater{
	private int speed;
	private int distance;
	public Running(int speed, int distance, double duration, int heartRate, char intensity, String feedback, String name) {
		super(duration, heartRate, intensity, feedback, name);
		this.speed = speed;
		this.distance = distance;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public double calculateCalories() {
        int caloriesBurned;
        caloriesBurned = (int) (intensity(getIntensity()) * (getDuration()/speed) * this.distance);
        return caloriesBurned;
    }
    @Override
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
        switch (attribute.toLowerCase()) {
            case "speed":
                this.speed = (int) newValue;
                break;
            case "distance":
                this.distance = (int) newValue;
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
        System.out.println("Running workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return "Speed: " + getSpeed() + ", Distance: " + getDistance();
    }

}
