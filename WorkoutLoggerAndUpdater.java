public interface WorkoutLoggerAndUpdater {
    void logWorkout();   
    void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException; 
    String getWorkoutDetails();
}
