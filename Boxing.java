public class Boxing extends Workout implements WorkoutUpdater{
	private int punches;
	private int rounds;
	
    public Boxing(double duration, int heartRate, char intensity ,int punches, int rounds) {
	super(duration, heartRate, intensity);
	this.punches = punches;
	this.rounds = rounds;
	
   }

	public int getPunches() {
		return punches;
	}

	public void setPunches(int punches) {
		this.punches = punches;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
    
	@Override
	public double calculateCalories() {
		double totalCalories = ((getPunches()*3.5)-1)+((getDuration()*10)-15);
		return totalCalories;
	}

	@Override
	public void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException {
		switch (attribute.toLowerCase()) {
			case "punches":
				this.punches = (int) newValue;
				break;
			case "rounds":
				this.rounds = (int) newValue;
				break;
			case "duration":
				setDuration((double) newValue); 
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
		System.out.println("Boxing workout updated: " + getWorkoutDetails());
	}
	


    @Override
    public String getWorkoutDetails() {
        return "Punches: " + getPunches() + ", Rounds: " + getRounds();
    }
	
}