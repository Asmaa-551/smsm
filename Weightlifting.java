public class Weightlifting extends Workout implements WorkoutUpdater{
	private double totalWeightLifted;
	private int numberOfSets ;

	public Weightlifting(double totalWeightLifted, int numberOfSets, double duration, int heartRate, char intensity) {
		super(duration, heartRate, intensity);
		this.totalWeightLifted = totalWeightLifted;
		this.numberOfSets = numberOfSets;
	}
	public double getTotalWeightLifted() {
		return totalWeightLifted;
	}
	public void setTotalWeightLifted(double totalWeightLifted) {
		this.totalWeightLifted = totalWeightLifted;
	}
	public int getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(int numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	
	@Override
	public double calculateCalories() {
        int caloriesBurned;

        caloriesBurned = (int) ((getDuration() * intensity(getIntensity())) + (totalWeightLifted / numberOfSets));
        setCaloriesBurned(caloriesBurned);
        return caloriesBurned;
    }
	
	@Override
	public String toString() {
		return super.toString() + "Weightlifitng [totalWeightLifted=" + totalWeightLifted + ", numberOfSets=" + numberOfSets + "]";
	}

    @Override
    public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
		switch (attribute.toLowerCase()) {
            case "totalweightlifted":
                this.totalWeightLifted = (double) newValue;
                break;
            case "numberofsets":
                this.numberOfSets = (int) newValue;
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
        System.out.println("Weightlifting workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return super.getWorkoutDetails()+ "Total Weight Lifted: " + getTotalWeightLifted() + ", Number Of Sets: " + getNumberOfSets();
    }
	
}
