public class Running extends Workout implements WorkoutLoggerAndUpdater{
	private int speed;
	private int distance;
	public Running(int speed, int distance, double duration, int heartRate, char intensity) {
		super(duration, heartRate, intensity);
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
    public void logWorkout() {
		WorkOutManager.addWorkout(this);
        System.out.println("Running workout logged: " + getWorkoutDetails());
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
            default:
            throw new InvalidAttributeException("Invalid attribute for Boxing workout: " + attribute);
        }
        System.out.println("Running workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return "Speed: " + getSpeed() + ", Distance: " + getDistance();
    }

}
