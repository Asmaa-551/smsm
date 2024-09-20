public class Boxing extends Workout {
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
	
}