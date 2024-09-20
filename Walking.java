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
        System.out.println("Walking workout logged: " + getWorkoutDetails());
    }

    @Override
    public void updateWorkout() {
        System.out.println("Walking workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return "Walk Speed: " + getWalkspeed() + ", Weight: " + getWeight();
    }

	

}
