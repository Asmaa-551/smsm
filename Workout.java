import java.time.LocalDateTime;

public abstract class Workout {
	private double duration; 
	private int caloriesBurned; 
	private int heartRate; 
	private char intensity;
	private String feedback;
	private LocalDateTime dateTime;
	private String name;
	
	public Workout() {
		this.dateTime = LocalDateTime.now();
	}
	
	public Workout(double duration, int heartRate, char intensity, String feedback, String name) {
		this.duration = duration;
		this.heartRate = heartRate;
		this.intensity = intensity;
		this.feedback = feedback;
		this.dateTime = LocalDateTime.now();
		this.name = name;
	}



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
	
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
	
	
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract double calculateCalories();
	
	@Override
	public String toString() {
		return "Workout [duration=" + duration + ", caloriesBurned=" + caloriesBurned
				+ ", heartRate=" + heartRate + "Intensity Level = " + intensity + "Date = " + dateTime + "]";
	}
	
}