public interface WorkoutUpdater {
    void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException; 
    String getWorkoutDetails();
}
