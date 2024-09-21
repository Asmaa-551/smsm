public class Walking extends Workout implements WorkoutUpdater{
	private double walkspeed;
	private double weight;
	

	public Walking(double duration, int heartRate, char intensity ,double walkspeed, double weight) {
		super(duration, heartRate, intensity);
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
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
		switch (attribute.toLowerCase()) {
            case "walkspeed":
                this.walkspeed = (double) newValue;
                break;
            case "weight":
                this.weight = (double) newValue;
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
        System.out.println("Walking workout updated: " + getWorkoutDetails());
	}

    @Override
    public String getWorkoutDetails() {
        return "Walk Speed: " + getWalkspeed() + ", Weight: " + getWeight();
    }

	

}
