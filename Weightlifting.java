public class Weightlifting extends Workout{
	private double totalWeightLifted;
	private int numberOfSets ;

	public Weightlifting(double totalWeightLifted, int numberOfSets, double duration, int heartRate, char intensity, String feedback, String name) {
		super(duration, heartRate, intensity, feedback, name);
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
	
}
