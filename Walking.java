public class Walking extends Workout implements WorkoutLoggerAndUpdater{
	private double walkspeed;
	private double weight;
	

	public Walking(double duration, int heartRate, char intensity, String feedback, String name ,double walkspeed, double weight) {
		super(duration, heartRate, intensity, feedback, name);
		this.walkspeed = walkspeed;
		this.weight = weight;
		
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWalkspeed() {
		return walkspeed;
	}

	public void setWalkspeed(double walkspeed) {
		this.walkspeed = walkspeed;
	}
	
	@Override
    public double calculateCalories() {
        double totalCalories = (getIntensity()-1) * getWeight() * getDuration();
        return totalCalories;
    }
	@Override
    public void logWorkout() {
		WorkOutManager.addWorkout(this);
        System.out.println("Walking workout logged: " + getWorkoutDetails());
    }

    @Override
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
		switch (attribute.toLowerCase()) {
            case "walkspeed":
                this.walkspeed = (double) newValue;
                break;
            case "weight":
                this.weight = (double) newValue;
                break;
            default:
			throw new InvalidAttributeException("Invalid attribute for Boxing workout: " + attribute);
        }
        System.out.println("Walking workout updated: " + getWorkoutDetails());
	}

    @Override
    public String getWorkoutDetails() {
        return "Walk Speed: " + getWalkspeed() + ", Weight: " + getWeight();
    }

	

}
