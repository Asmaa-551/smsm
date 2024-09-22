public interface WorkoutUpdater {
    //enables the workout settings to be updated continuously by the specified name
    //InvalidAttributeException if the attribute cannot be located or is invalid
    void updateWorkout(String attribute, Object newValue) throws InvalidAttributeException; 
    String getWorkoutDetails();
}
