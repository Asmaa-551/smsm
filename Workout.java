import java.time.LocalDateTime;

public abstract class Workout {
	private double duration; 
	private int caloriesBurned; 
	private int heartRate; 
	private char intensity;
	private LocalDateTime dateTime;
	
	public Workout() {
		this.dateTime = LocalDateTime.now();
	}
	
	public Workout(double duration, int heartRate, char intensity) {
		this.duration = duration;
		this.heartRate = heartRate;
		this.intensity = intensity;
		this.dateTime = LocalDateTime.now();
	}
	public abstract double calculateCalories();
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	
	public char getIntensity() {
		return intensity;
	}
	public void setIntensity(char intensity) {
		this.intensity = intensity;
	}
	

	public double intensity(char intensity) {
	    switch (intensity) {
	        case 'L':
	            return 4.5;
	        case 'M':
	            return 6.0;
	        case 'H':
	            return 8.0;
	        default:
	        	return 1.0;	    
	       }
	}
	
	// Confirms that the workout has been logged by adding it to the WorkOutManager class and printing a message
    public void logWorkout() {
		WorkOutManager.addWorkout(this);
        System.out.println("Workout logged: " + getWorkoutDetails());
    }

	@Override
	public String toString() {
		return "Workout [duration=" + duration + ", caloriesBurned=" + caloriesBurned
				+ ", heartRate=" + heartRate + "Intensity Level = " + intensity + "Date = " + dateTime + "]";
	}

    public String getWorkoutDetails() {
        return "Duration: " + getDuration();
    }

	
}