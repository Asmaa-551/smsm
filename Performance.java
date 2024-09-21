import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Performance {
    private List<Workout> workouts;
    private List<Water> water;
    private List<FoodItem> foodItems;


    public Performance(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }
    public Performance(List<Workout> workouts, List<Water> water, List<FoodItem> foodItems) {
        this.workouts = workouts;
        this.water = water;
        this.foodItems = foodItems;
    }

    public void generateWeeklyReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekAgo = now.minusDays(7);
    
        ArrayList<Workout> weeklyWorkouts = filterWorkoutsByDate(oneWeekAgo, now);
        ArrayList<FoodItem> weeklyFoodItems = filterFoodByDate(oneWeekAgo, now);
        ArrayList<Water> weeklyWater = filterWaterByDate(oneWeekAgo, now);
    
        System.out.println("Weekly Performance Report:");
        generateReport(weeklyWorkouts, weeklyFoodItems, weeklyWater);
    }
    
    public void generateMonthlyReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusDays(30);
    
        ArrayList<Workout> monthlyWorkouts = filterWorkoutsByDate(oneMonthAgo, now);
        ArrayList<FoodItem> monthlyFoodItems = filterFoodByDate(oneMonthAgo, now);
        ArrayList<Water> monthlyWater = filterWaterByDate(oneMonthAgo, now);
    
        System.out.println("Monthly Performance Report:");
        generateReport(monthlyWorkouts, monthlyFoodItems, monthlyWater);
    }

    private ArrayList<Workout> filterWorkoutsByDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        ArrayList<Workout> filteredWorkouts = new ArrayList<>();
        
        for (Workout workout : workouts) {
            LocalDateTime workoutDateTime = workout.getDateTime();
            if (!workoutDateTime.isBefore(startDateTime) && !workoutDateTime.isAfter(endDateTime)) {
                filteredWorkouts.add(workout); 
            }
        }
        
        return filteredWorkouts; 
    }

    public ArrayList<FoodItem> filterFoodByDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        ArrayList<FoodItem> filteredFoodItems = new ArrayList<>();
        for (FoodItem item : foodItems) {
            if (!item.getDateLogged().isBefore(startDateTime) && !item.getDateLogged().isAfter(endDateTime)) {
                filteredFoodItems.add(item);
            }
        }
        return filteredFoodItems;
    }

    public ArrayList<Water> filterWaterByDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        ArrayList<Water> filteredWater = new ArrayList<>();
        for (Water waterEntry : water) {
            if (!waterEntry.getIntakeDateTime().isBefore(startDateTime) && !waterEntry.getIntakeDateTime().isAfter(endDateTime)) {
                filteredWater.add(waterEntry);
            }
        }
        return filteredWater;
    }

    public void generateReport(ArrayList<Workout> filteredWorkouts, ArrayList<FoodItem> filteredFoodItems, ArrayList<Water> filteredWater) {
        int totalCaloriesBurned = 0;
        double totalDuration = 0;
    
        // Accumulators for averages and counts
        double totalRunningSpeed = 0;
        double totalRunningDistance = 0;
        double totalCyclingPower = 0;
        double totalCyclingSpeed = 0;
        double totalCyclingDistance = 0;
        double totalSwimmingDepth = 0;
        int totalNumSwimRounds = 0;
        double totalWalkingSpeed = 0;
        int totalNumRounds = 0;
        int totalBoxingPunches = 0;
        double totalWeightLifted = 0;
        int totalNumSets = 0;
    
        int runningCount = 0, cyclingCount = 0, swimmingCount = 0, walkingCount = 0, boxingCount = 0, weightliftingCount = 0;
    
        for (Workout workout : filteredWorkouts) {
            int calories = (int) workout.calculateCalories();
            totalCaloriesBurned += calories;
            totalDuration += (int) workout.getDuration();
    
            if (workout instanceof Running) {
                Running run = (Running) workout;
                totalRunningSpeed += run.getSpeed();
                totalRunningDistance += run.getDistance();
                runningCount++;
            } else if (workout instanceof Cycling) {
                Cycling cycle = (Cycling) workout;
                totalCyclingPower += cycle.getCyclingPower();
                totalCyclingSpeed += cycle.getCyclingSpeed();
                totalCyclingDistance += cycle.getCyclingDistance();
                cyclingCount++;
            } else if (workout instanceof Swimming) {
                Swimming swim = (Swimming) workout;
                totalSwimmingDepth += swim.getUnderwaterDepth();
                totalNumSwimRounds += swim.getLaps();
                swimmingCount++;
            } else if (workout instanceof Walking) {
                Walking walk = (Walking) workout;
                totalWalkingSpeed += walk.getWalkspeed();
                walkingCount++;
            } else if (workout instanceof Boxing) {
                Boxing box = (Boxing) workout;
                totalBoxingPunches += box.getPunches();
                totalNumRounds += box.getRounds();
                boxingCount++;
            } else if (workout instanceof Weightlifting) {
                Weightlifting lift = (Weightlifting) workout;
                totalWeightLifted += lift.getTotalWeightLifted();
                totalNumSets += lift.getNumberOfSets();
                weightliftingCount++;
            }
        }
        
        int totalFoodCalories = 0;
        double totalWaterIntake = 0;
        int totalProteinsConsumed = 0;
    
        for (FoodItem item : filteredFoodItems) {
            totalFoodCalories += item.getCalories();
            totalProteinsConsumed += item.getProteins();

        }
    
        for (Water waterEntry : filteredWater) {
            totalWaterIntake += waterEntry.getWaterAmount();
        }
    
        int netCalories = totalFoodCalories - totalCaloriesBurned;

        System.out.println("Overall Total Duration: " + totalDuration / 60 + " hours");
        System.out.println("Overall Total Calories Burned: " + totalCaloriesBurned + " calories");
        System.out.println("Net Calories (Consumed - Burned): " + netCalories + " calories");
        System.out.println("Total Water Consumed: " + totalWaterIntake + " liters");
        System.out.println("Total Proteins Consumed: " + totalProteinsConsumed + " grams");


    
        if (runningCount > 0) {
            double avgSpeed = totalRunningSpeed / runningCount;
            System.out.printf("Total runs: %d with an average speed of %.2f and a total distance of %.2f km.%n", runningCount, avgSpeed, totalRunningDistance);
        }
    
        if (cyclingCount > 0) {
            double avgPower = totalCyclingPower / cyclingCount;
            double avgSpeed = totalCyclingSpeed / cyclingCount;
            System.out.printf("Total cycling sessions: %d with an average power of %.2f, average speed of %.2f km/h, and a total distance of %.2f km.%n", cyclingCount, avgPower, avgSpeed, totalCyclingDistance);
        }
    
        if (swimmingCount > 0) {
            double avgDepth = totalSwimmingDepth / swimmingCount;
            System.out.printf("Total swims: %d with an average underwater depth of %.2f meters and a total of %.2f laps.%n", swimmingCount, avgDepth, totalNumSwimRounds);
        }
    
        if (walkingCount > 0) {
            double avgSpeed = totalWalkingSpeed / walkingCount;
            System.out.printf("Total walks: %d with an average speed of %.2f km/h.%n", walkingCount, avgSpeed);
        }
    
        if (boxingCount > 0) {
            System.out.printf("Total boxing sessions: %d with a total of %d punches and an total of %.2f rounds.%n", boxingCount, totalBoxingPunches, totalNumRounds);
        }
    
        if (weightliftingCount > 0) {
            double avgWeight = totalWeightLifted / weightliftingCount;
            System.out.printf("Total weightlifting sessions: %d with an average total weight lifted of %.2f kg and a total of %.2f sets.%n", weightliftingCount, avgWeight, totalNumSets);
        }
    }
    

}