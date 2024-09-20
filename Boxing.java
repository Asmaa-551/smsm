public class Boxing extends Workout implements WorkoutLoggerAndUpdater{
	private int punches;
	private int rounds;
	
    public Boxing(double duration, int heartRate, char intensity, String feedback, String name ,int punches, int rounds) {
	super(duration, heartRate, intensity, feedback, name);
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
    public void logWorkout() {
		WorkOutManager.addWorkout(this);
        System.out.println("Boxing workout logged: " + getWorkoutDetails());
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
            default:
			throw new InvalidAttributeException("Invalid attribute for Boxing workout: " + attribute);
        }
        System.out.println("Boxing workout updated: " + getWorkoutDetails());
    }

    @Override
    public String getWorkoutDetails() {
        return "Punches: " + getPunches() + ", Rounds: " + getRounds();
    }
	
}