import java.util.ArrayList;

public class ActivityManager {
    private static ArrayList<Workout> workouts;

    public ActivityManager() {
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
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
}
