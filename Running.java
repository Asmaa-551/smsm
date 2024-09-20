public class Running extends Workout{
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

}
