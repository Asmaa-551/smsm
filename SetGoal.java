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

    public SetGoal(int dailyGoalCalories, double dailyDurationGoal, double dailyWaterGoal, double dailyProteinGoal,
                   int weeklyGoalCalories, double weeklyDurationGoal, double weeklyWaterGoal, double weeklyProteinGoal,
                   int monthlyGoalCalories, double monthlyDurationGoal, double monthlyWaterGoal, double monthlyProteinGoal) {
        this.dailyGoalCalories = dailyGoalCalories;
        this.dailyDurationGoal = dailyDurationGoal;
        this.dailyWaterGoal = dailyWaterGoal;
        this.dailyProteinGoal = dailyProteinGoal;
        this.weeklyGoalCalories = weeklyGoalCalories;
        this.weeklyDurationGoal = weeklyDurationGoal;
        this.weeklyWaterGoal = weeklyWaterGoal;
        this.weeklyProteinGoal = weeklyProteinGoal;
        this.monthlyGoalCalories = monthlyGoalCalories;
        this.monthlyDurationGoal = monthlyDurationGoal;
        this.monthlyWaterGoal = monthlyWaterGoal;
        this.monthlyProteinGoal = monthlyProteinGoal;
    }

    public void setUpdateGoals() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Set or Update Fitness Goals:");
        System.out.println("Choose goal type: 1 - Daily, 2 - Weekly, 3 - Monthly");
        
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                dailyGoalStartTime = LocalDate.now().atStartOfDay();
                System.out.println("Setting Daily Goals:");
                System.out.print("Calories Burned: ");
                dailyGoalCalories = input.nextInt();
                System.out.print("Workout Duration (minutes): ");
                dailyDurationGoal = input.nextDouble();
                System.out.print("Water Intake (liters): ");
                dailyWaterGoal = input.nextDouble();
                System.out.print("Protein Intake (grams): ");
                dailyProteinGoal = input.nextDouble();
                System.out.println("Daily goals updated successfully!");
                break;
            
            case 2:
                weeklyGoalStartTime = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).atStartOfDay(); // Set to start of the week
                System.out.println("Setting Weekly Goals:");
                System.out.print("Calories Burned: ");
                weeklyGoalCalories = input.nextInt();
                System.out.print("Workout Duration (minutes): ");
                weeklyDurationGoal = input.nextDouble();
                System.out.print("Water Intake (liters): ");
                weeklyWaterGoal = input.nextDouble();
                System.out.print("Protein Intake (grams): ");
                weeklyProteinGoal = input.nextDouble();
                System.out.println("Weekly goals updated successfully!");
                break;
            
            case 3:
                monthlyGoalStartTime = LocalDate.now().withDayOfMonth(1).atStartOfDay(); // Set to start of the month
                System.out.println("Setting Monthly Goals:");
                System.out.print("Calories Burned: ");
                monthlyGoalCalories = input.nextInt();
                System.out.print("Workout Duration (minutes): ");
                monthlyDurationGoal = input.nextDouble();
                System.out.print("Water Intake (liters): ");
                monthlyWaterGoal = input.nextDouble();
                System.out.print("Protein Intake (grams): ");
                monthlyProteinGoal = input.nextDouble();
                System.out.println("Monthly goals updated successfully!");
                break;
            
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }

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
    
        checkGoal("calories", totalCalories, weeklyGoalCalories, weeklyGoalStartTime, "weekly");
        checkGoal("workout duration", totalDuration, weeklyDurationGoal, weeklyGoalStartTime, "weekly");
        checkGoal("water intake", totalWater, weeklyWaterGoal, weeklyGoalStartTime, "weekly");
        checkGoal("protein intake", totalProtein, weeklyProteinGoal, weeklyGoalStartTime, "weekly");
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
        if (currentValue >= goalValue) {
            System.out.println("Congratulations! You've reached your " + goalType + " goal of " + goalValue + ".");
        } else {
            double remaining = goalValue - currentValue;
            System.out.println("You need " + remaining + " more " + goalType + " to reach your goal.");
        }
    }
}
