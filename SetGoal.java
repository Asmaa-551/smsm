import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SetGoal {
	private int goalCaloriesBurned;
    private boolean ReachGoalC;
	private double durationGoal;
    private boolean ReachGoalD;
	private String goalType;

    private double waterGoal;
    private double proteinGoal;
    

	public SetGoal(int goalCaloriesBurned, double durationGoal, double waterGoal, double proteinGoal) {
		this.goalCaloriesBurned = goalCaloriesBurned;
		this.durationGoal = durationGoal;
        this.waterGoal = waterGoal; 
        this.proteinGoal = proteinGoal;	
	}

    public void setUpdategoals() {
        Scanner input = new Scanner(System.in);
        System.out.println("Set or Update Fitness Goals:");
        System.out.println("Choose goal type: 1- Daily  2- Weekly  3- Monthly");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                goalType = "Daily";
                break;
            case 2:
                goalType = "Weekly";
                break;
            case 3:
                goalType = "Monthly";
                break;
            default:
                System.out.println("Invalid choice , Defaulting to Daily");
                goalType = "Daily";
                break;
        }

        System.out.println("Your goal type is set to: " + goalType);
    }

    public void checkGoals(WorkOutManager manager) {
        int totalCalories = 0;
        double totalDuration = 0;

        LocalDate today = LocalDate.now();

        for (Workout workout : manager.getWorkouts()) {
            LocalDateTime workoutDateTime = workout.getDateTime();
            LocalDate workoutDate = workoutDateTime.toLocalDate(); 

            switch (goalType) {
                case "Daily":
                    if (workoutDate.equals(today)) {
                        totalCalories += workout.calculateCalories();
                        totalDuration += workout.getDuration();
                    }
                    break;

                case "Weekly":
                    WeekFields weekFields = WeekFields.of(Locale.getDefault());
                    int currentWeek = today.get(weekFields.weekOfWeekBasedYear());
                    int workoutWeek = workoutDate.get(weekFields.weekOfWeekBasedYear());

                    if (workoutWeek == currentWeek) {
                        totalCalories += workout.calculateCalories();
                        totalDuration += workout.getDuration();
                    }
                    break;

                case "Monthly":
                    if (workoutDate.getMonth().equals(today.getMonth()) && workoutDate.getYear() == today.getYear()) {
                        totalCalories += workout.calculateCalories();
                        totalDuration += workout.getDuration();
                    }
                    break;

                default:
                    System.out.println("Invalid goal type");
            }
        }

		if(totalCalories >= goalCaloriesBurned) {
			ReachGoalC = true ;
            System.out.println("Congratulations! You have burned " + totalCalories + " calories, reaching your goal of " + goalCaloriesBurned + " calories!");
		}
	    else{
            int caloriesLeft = goalCaloriesBurned - totalCalories;
			System.out.println("Keep going! You need " + caloriesLeft + " more calories to reach your goal of " + goalCaloriesBurned + " calories");
			}
        
        if(totalDuration >= durationGoal) {
                ReachGoalD = true ;
                System.out.println("Great job! You've worked out for " + totalDuration + " minutes, reaching your goal of " + durationGoal + " minutes! ");
        }
         else{
            double minutesLeft = durationGoal - totalDuration;
            System.out.println("You're almost there! You need " + minutesLeft + " more minutes to reach your goal of " + durationGoal + " minutes ");
             }
            }

            public void checkWaterGoals(Water[] waterIntakes) {
                double totalWater = 0;
                LocalDate today = LocalDate.now();
        
                for (Water water : waterIntakes) {
                    LocalDateTime waterDateTime = water.getIntakeDateTime();
                    LocalDate waterDate = waterDateTime.toLocalDate();
        
                    switch (goalType) {
                        case "Daily":
                            if (waterDate.equals(today)) {
                                totalWater += water.getWaterAmount();
                            }
                            break;
                        case "Weekly":
                            WeekFields weekFields = WeekFields.of(Locale.getDefault());
                            int currentWeek = today.get(weekFields.weekOfWeekBasedYear());
                            int waterWeek = waterDate.get(weekFields.weekOfWeekBasedYear());
        
                            if (waterWeek == currentWeek) {
                                totalWater += water.getWaterAmount();
                            }
                            break;
                        case "Monthly":
                            if (waterDate.getMonth().equals(today.getMonth()) && waterDate.getYear() == today.getYear()) {
                                totalWater += water.getWaterAmount();
                            }
                            break;
                    }
                }
        
                if (totalWater >= waterGoal) {
                    System.out.println("You have reached your water intake goal!");
                } else {
                    System.out.println("You need " + (waterGoal - totalWater) + " more liters of water to reach your goal.");
                }
            }

            public void checkProteinGoals(FoodItem[] foodItems) {
                double totalProtein = 0;
                LocalDate today = LocalDate.now();
        
                for (FoodItem food : foodItems) {
                    LocalDateTime foodDateTime = food.getDateLogged();
                    LocalDate foodDate = foodDateTime.toLocalDate();
        
                    switch (goalType) {
                        case "Daily":
                            if (foodDate.equals(today)) {
                                totalProtein += food.getProteins();
                            }
                            break;
                        case "Weekly":
                            WeekFields weekFields = WeekFields.of(Locale.getDefault());
                            int currentWeek = today.get(weekFields.weekOfWeekBasedYear());
                            int foodWeek = foodDate.get(weekFields.weekOfWeekBasedYear());
        
                            if (foodWeek == currentWeek) {
                                totalProtein += food.getProteins();
                            }
                            break;
                        case "Monthly":
                            if (foodDate.getMonth().equals(today.getMonth()) && foodDate.getYear() == today.getYear()) {
                                totalProtein += food.getProteins();
                            }
                            break;
                    }
                }
        
                if (totalProtein >= proteinGoal) {
                    System.out.println("You have reached your protein intake goal!");
                } else {
                    System.out.println("You need " + (proteinGoal - totalProtein) + " more grams of protein to reach your goal.");
                }
            }
		
            public void updateGoal(WorkOutManager manager, int index, int newGoalCaloriesBurned, double newDurationGoal, double newWaterGoal, double newProteinGoal) {
                if (index >= 0 && index < manager.getWorkouts().size()) {
                    this.goalCaloriesBurned = newGoalCaloriesBurned;
                    this.durationGoal = newDurationGoal;
                    this.waterGoal = newWaterGoal;
                    this.proteinGoal = newProteinGoal;
            
                    System.out.println("Calories Updated Goal: " + goalCaloriesBurned + " kcal");
                    System.out.println("Duration Updated Goal: " + durationGoal + " minutes");
                    System.out.println("Water Intake Goal Updated: " + waterGoal + " liters");
                    System.out.println("Protein Intake Goal Updated: " + proteinGoal + " grams");
                } else {
                    System.out.println("Invalid workout index");
                }
            }
            
            
        }
		
	


		
		
		
	
	
	

	
	
	



