import java.util.ArrayList;
import java.util.List;

public class WorkOutManager {
    private List<Workout> workouts;

    public WorkOutManager() {
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
        System.out.println("Workout added: " + workout.getName() + " at " + workout.getDateTime());
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

    public void updateWorkout(int index, double newDuration, int newHeartRate, char newIntensity, String newFeedback) {
        if (index >= 0 && index < workouts.size()) {
            Workout workoutUpdate = workouts.get(index);
            workoutUpdate.setDuration(newDuration);
            workoutUpdate.setHeartRate(newHeartRate);
            workoutUpdate.setIntensity(newIntensity);
            workoutUpdate.setFeedback(newFeedback);
            System.out.println("Workout updated at index " + index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}
