import java.util.ArrayList;

public class WorkOutManager {
    private static ArrayList<Workout> workouts;

    public WorkOutManager() {
        workouts = new ArrayList<>();
    }

    public static void addWorkout(Workout workout) {
        workouts.add(workout);
        System.out.println("Workout added at " + workout.getDateTime());
    }

    public void displayWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workout logged");
        } else {
            System.out.println("Logged Workouts:");
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
    //         Swimming swim = new Swimming(newDuration, newHeartRate, newHeartRate, newIntensity, newFeedback, newFeedback, newDuration, newFeedback, newHeartRate);
    //         workouts.set(index, swim);

    //         System.out.println("Workout updated at index " + index);
    //     } else {
    //         System.out.println("Invalid index");
    //     }
    // }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
}
