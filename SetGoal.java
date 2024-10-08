import java.util.*;
import java.time.*;
import java.time.temporal.WeekFields;

public class SetGoal {
    private int dailyGoalCalories;
    private double dailyDurationGoal;
    private double dailyWaterGoal;
    private double dailyProteinGoal;

    private int weeklyGoalCalories;
    private double weeklyDurationGoal;
    private double weeklyWaterGoal;
    private double weeklyProteinGoal;

    private int monthlyGoalCalories;
    private double monthlyDurationGoal;
    private double monthlyWaterGoal;
    private double monthlyProteinGoal;
    private LocalDateTime dailyGoalStartTime;
    private LocalDateTime weeklyGoalStartTime;
    private LocalDateTime monthlyGoalStartTime;

    public SetGoal() {}

    // Gives the user the option to create or modify goals on a daily, weekly, or monthly basis.
    public void setUpdateGoals() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Set or Update Fitness Goals:");
        System.out.println("Choose goal type: 1 - Daily, 2 - Weekly, 3 - Monthly");
        
        int choice = input.nextInt();
        try{
        switch (choice) {
            case 1:
                dailyGoalStartTime = LocalDate.now().atStartOfDay();
                System.out.println("Setting Daily Goals:");
                do {
                    System.out.print("Calories Burned: ");
                    dailyGoalCalories = input.nextInt();
                    if (dailyGoalCalories < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (dailyGoalCalories < 0);
                do {
                    System.out.print("Workout Duration (minutes): ");
                    dailyDurationGoal = input.nextDouble();
                    if (dailyDurationGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (dailyDurationGoal < 0);
                do {
                    System.out.print("Water Intake (liters): ");
                    dailyWaterGoal = input.nextDouble();
                    if (dailyWaterGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (dailyWaterGoal < 0);
                do {
                    System.out.print("Protein Intake (grams): ");
                    dailyProteinGoal = input.nextDouble();
                    if (dailyProteinGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (dailyProteinGoal < 0);
                System.out.println("Daily goals updated successfully!");
                break;
            
            case 2:
                weeklyGoalStartTime = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).atStartOfDay(); // Set to start of the week
                System.out.println("Setting Weekly Goals:");
                do {
                    System.out.print("Weekly Calories Burned Goal: ");
                    weeklyGoalCalories = input.nextInt();
                    if (weeklyGoalCalories < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (weeklyGoalCalories < 0);
                
                do {
                    System.out.print("Weekly Workout Duration (minutes): ");
                    weeklyDurationGoal = input.nextDouble();
                    if (weeklyDurationGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (weeklyDurationGoal < 0);
                
                do {
                    System.out.print("Weekly Water Intake (liters): ");
                    weeklyWaterGoal = input.nextDouble();
                    if (weeklyWaterGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (weeklyWaterGoal < 0);
                
                do {
                    System.out.print("Weekly Protein Intake (grams): ");
                    weeklyProteinGoal = input.nextDouble();
                    if (weeklyProteinGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (weeklyProteinGoal < 0);
                
                System.out.println("Weekly goals updated successfully!");
                break;
            
            case 3:
                monthlyGoalStartTime = LocalDate.now().withDayOfMonth(1).atStartOfDay(); // Set to start of the month
                System.out.println("Setting Monthly Goals:");
                do {
                    System.out.print("Monthly Calories Burned Goal: ");
                    monthlyGoalCalories = input.nextInt();
                    if (monthlyGoalCalories < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (monthlyGoalCalories < 0);
                
                do {
                    System.out.print("Monthly Workout Duration (minutes): ");
                    monthlyDurationGoal = input.nextDouble();
                    if (monthlyDurationGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (monthlyDurationGoal < 0);
                
                do {
                    System.out.print("Monthly Water Intake (liters): ");
                    monthlyWaterGoal = input.nextDouble();
                    if (monthlyWaterGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (monthlyWaterGoal < 0);
                
                do {
                    System.out.print("Monthly Protein Intake (grams): ");
                    monthlyProteinGoal = input.nextDouble();
                    if (monthlyProteinGoal < 0) {
                        System.out.println("Please enter a positive value.");
                    }
                } while (monthlyProteinGoal < 0);
                System.out.println("Monthly goals updated successfully!");
                break;
            
            default:
                throw new InvalidChoiceException("Invalid choice. Please select 1, 2, or 3.");
        }
        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }
    }

    // Using the user's food, water, and exercise logs, this function determines if the user has reached their daily targets
    public void checkDailyGoals(ActivityManager manager, ArrayList<HydrationMonitor> waterIntakes, ArrayList<Dish> foodItems) {
        LocalDate today = LocalDate.now();
        int totalCalories = 0;
        double totalDuration = 0;
        double totalWater = 0;
        double totalProtein = 0;
    
        for (Workout workout : manager.getWorkouts()) {
            LocalDate workoutDate = workout.getDateTime().toLocalDate();
            if (workoutDate.equals(today)) {
                totalCalories += workout.calculateCalories();
                totalDuration += workout.getDuration();
            }
        }
    
        for (HydrationMonitor water : waterIntakes) {
            LocalDate waterDate = water.getIntakeDateTime().toLocalDate();
            if (waterDate.equals(today)) {
                totalWater += water.getWaterAmount();
            }
        }
    
        for (Dish food : foodItems) {
            LocalDate foodDate = food.getDateLogged().toLocalDate();
            if (foodDate.equals(today)) {
                totalProtein += food.getProteins();
            }
        }
    
        checkGoal("calories", totalCalories, dailyGoalCalories, dailyGoalStartTime, "daily"); 
        checkGoal("workout duration", totalDuration, dailyDurationGoal, dailyGoalStartTime, "daily");
        checkGoal("water intake", totalWater, dailyWaterGoal, dailyGoalStartTime, "daily");
        checkGoal("protein intake", totalProtein, dailyProteinGoal, dailyGoalStartTime, "daily");
    }

    public void checkWeeklyGoals(ActivityManager manager, ArrayList<HydrationMonitor> waterIntakes, ArrayList<Dish> foodItems) {
        LocalDate today = LocalDate.now();
        LocalDate weekStart = today.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
    
        int totalCalories = 0;
        double totalDuration = 0;
        double totalWater = 0;
        double totalProtein = 0;
    
        for (Workout workout : manager.getWorkouts()) {
            LocalDate workoutDate = workout.getDateTime().toLocalDate();
            if (!workoutDate.isBefore(weekStart)) {
                totalCalories += workout.calculateCalories();
                totalDuration += workout.getDuration();
            }
        }
    
        for (HydrationMonitor water : waterIntakes) {
            LocalDate waterDate = water.getIntakeDateTime().toLocalDate();
            if (!waterDate.isBefore(weekStart)) {
                totalWater += water.getWaterAmount();
            }
        }
    
        for (Dish food : foodItems) {
            LocalDate foodDate = food.getDateLogged().toLocalDate();
            if (!foodDate.isBefore(weekStart)) {
                totalProtein += food.getProteins();
            }
        }
    
        checkGoal("Calories", totalCalories, weeklyGoalCalories, weeklyGoalStartTime, "weekly");
        checkGoal("Workout duration", totalDuration, weeklyDurationGoal, weeklyGoalStartTime, "weekly");
        checkGoal("Water intake", totalWater, weeklyWaterGoal, weeklyGoalStartTime, "weekly");
        checkGoal("Protein intake", totalProtein, weeklyProteinGoal, weeklyGoalStartTime, "weekly");
    }

    public void checkMonthlyGoals(ActivityManager manager, ArrayList<HydrationMonitor> waterIntakes, ArrayList<Dish> foodItems) {
        LocalDate today = LocalDate.now();
        LocalDate monthStart = today.withDayOfMonth(1);
    
        int totalCalories = 0;
        double totalDuration = 0;
        double totalWater = 0;
        double totalProtein = 0;
    
        for (Workout workout : manager.getWorkouts()) {
            LocalDate workoutDate = workout.getDateTime().toLocalDate();
            if (!workoutDate.isBefore(monthStart)) {
                totalCalories += workout.calculateCalories();
                totalDuration += workout.getDuration();
            }
        }
    
        for (HydrationMonitor water : waterIntakes) {
            LocalDate waterDate = water.getIntakeDateTime().toLocalDate();
            if (!waterDate.isBefore(monthStart)) {
                totalWater += water.getWaterAmount();
            }
        }
    
        for (Dish food : foodItems) {
            LocalDate foodDate = food.getDateLogged().toLocalDate();
            if (!foodDate.isBefore(monthStart)) {
                totalProtein += food.getProteins();
            }
        }
    
        checkGoal("calories", totalCalories, monthlyGoalCalories, monthlyGoalStartTime, "monthly");
        checkGoal("workout duration", totalDuration, monthlyDurationGoal, monthlyGoalStartTime, "monthly");
        checkGoal("water intake", totalWater, monthlyWaterGoal, monthlyGoalStartTime, "monthly");
        checkGoal("protein intake", totalProtein, monthlyProteinGoal, monthlyGoalStartTime, "monthly");
    }

    public void checkGoal(String goalType, double currentValue, double goalValue, LocalDateTime startTime, String period) {
        if (goalValue <= 0) {
            System.out.println("Goal for " + goalType + " is not set.");
            return;
        }
        if (currentValue >= goalValue) {
            System.out.println("Congratulations! You've reached your " + goalType + " goal of " + goalValue + ".");
        } else {
            double remaining = goalValue - currentValue;
            System.out.println("You need " + remaining + " more " + goalType + " to reach your goal.");
        }
    }
}
