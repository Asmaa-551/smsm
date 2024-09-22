import java.util.ArrayList;

public class ActivityManager {
    private static ArrayList<Workout> workouts;

    public ActivityManager() {
        workouts = new ArrayList<>();
    }

    // Adds the workout to the list 
    public static void addWorkout(Workout workout) {
        workouts.add(workout);
        System.out.println("Workout added at " + workout.getDateTime());
    }
    // examines that the exercise list is empty. Print a message if no workouts have been recorded
    public void displayWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workout logged");
        } else {
            // Print a header message and show each workout if there are any logged workouts
            System.out.println("Logged Workouts:");
            // Prints each exercise after iterating through the list
            for (int i = 0; i < workouts.size(); i++) {
                Workout workout = workouts.get(i);
                System.out.println(workout);
            }

        }
    }
    // public void updateWorkout(int index, double newDuration, int newHeartRate, char newIntensity, String newFeedback) {
    //     if (index >= 0 && index < workouts.size()) {
    //         Workout workoutUpdate = workouts.get(index);
    //         workoutUpdate.setDuration(newDuration);
    //         workoutUpdate.setHeartRate(newHeartRate);
    //         workoutUpdate.setIntensity(newIntensity);
    //         workoutUpdate.setFeedback(newFeedback);

    //         System.out.println("Workout updated at index " + index);
    //     } else {
    //         System.out.println("Invalid index");
    //     }
    // }
    
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
}
