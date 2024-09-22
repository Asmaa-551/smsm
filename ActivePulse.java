import java.util.Scanner;
import java.util.ArrayList;


public class ActivePulse {

	private static ActivityManager workoutManager = new ActivityManager();
	private static Diet diet = new Diet();
	private static SetGoal goal = new SetGoal();


	public static void main(String[] args) {
		int userChoice;
		do {
			DislayMenu();
			userChoice = UserMenuChoice();
			switch (userChoice) {
				case 1: LogNewWorkout(); break; 	
				case 2: logFoodOrWater(); break;	
				case 3: UpdateWorkout(); break;	
				case 4: SetUpdateFitnessGoals(); break;		
				case 5: ViewProgress(); break;	
				case 6: logFoodOrWater(); break;
				case 7: GeneratePerformanceReports(); break;	

				default:  System.out.println("Thank You for Using CSC301's ActivePulse (A Personal Fitness Tracker App), Have a Nice Day.");
			}
		}while (userChoice != 0);
	}
	
	public static void DislayMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Personal Fitness Tracker System (ActivePulse, Fall 24-25)");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Log a new workout (Running, Cycling, Weightlifting, Swimming, ...)");
		System.out.println("2. Log nutritional intake (meals and water).");
		System.out.println("3. Update workout details (duration, distance, calories, etc.)");
		System.out.println("4. Set or update fitness goals.");
		System.out.println("5. View progress toward goals.");
		System.out.println("6. Log nutritional intake (meals and water).");
		System.out.println("7. Generate performance reports (weekly, monthly, etc.)");
		System.out.println("0. Exit");
		System.out.println("------------------------------------------------------------");
	}

	public static int UserMenuChoice(){
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Your Choice (0, 1, 2, 3, 4, 5, 6, 7):");
			choice = input.nextInt();
		} while(choice > 6);
		return choice;
	}
	
	public static void LogNewWorkout() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose workout type: 1. Walking 2. Running 3. Cycling 4. Swimming 5. Boxing 6. Weightlifting");
		int workoutType = input.nextInt();
		
		Workout workout = null;
		
		System.out.println("Enter duration (in minutes): ");
		double duration = input.nextDouble();
		System.out.println("Enter heart rate (in bpm): ");
		int heartRate = input.nextInt();
		System.out.println("Enter intensity (e.g., A, B, C): ");
		char intensity = input.next().charAt(0);

	
		switch (workoutType) {
			case 1: // Walking
				System.out.println("Enter walk speed (in km/h): ");
				double walkSpeed = input.nextDouble();
				System.out.println("Enter your weight (in kg): ");
				double weight = input.nextDouble();
				workout = new Walking( duration, heartRate, intensity , walkSpeed, weight);
				break;
	
			case 2: // Running
				System.out.println("Enter distance (in kilometers): ");
				int runningDistance = input.nextInt();
				System.out.println("Enter walk speed (in km/h): ");
				int speed = input.nextInt();
				workout = new Running(speed, runningDistance, duration, heartRate, intensity);
				break;
	
			case 3: // Cycling
				System.out.println("Enter cycling power (in watts): ");
				double cyclingPower = input.nextDouble();
				System.out.println("Enter cycling speed (in km/h): ");
				double cyclingSpeed = input.nextDouble();
				System.out.println("Enter cycling distance (in kilometers): ");
				double cyclingDistance = input.nextDouble();
				workout = new Cycling( duration, heartRate, intensity,cyclingDistance, cyclingPower, cyclingSpeed);
				break;
	
			case 4: // Swimming
				System.out.println("Enter underwater depth (in meters): ");
				double underwaterDepth = input.nextDouble();
				System.out.println("Enter swimming style (freestyle, breaststroke, backstroke, butterfly): ");
				String swimmingStyle = input.next();
				System.out.println("Enter number of laps: ");
				int laps = input.nextInt();
				
				workout = new Swimming( duration, heartRate, intensity, underwaterDepth, swimmingStyle, laps);
				break;
	
			case 5: // Boxing
				System.out.println("Enter number of punches: ");
				int punches = input.nextInt();
				System.out.println("Enter number of rounds: ");
				int rounds = input.nextInt();
				workout = new Boxing( duration, heartRate, intensity , punches, rounds);
				break;
	
			case 6: // Weightlifting
				System.out.println("Enter total weight lifted (in kg): ");
				double totalWeightLifted = input.nextDouble();
				System.out.println("Enter number of sets: ");
				int numberOfSets = input.nextInt();
				workout = new Weightlifting( totalWeightLifted, numberOfSets, duration, heartRate, intensity);
				break;
	
			default:
				System.out.println("Invalid workout type selected.");
				return;
		}
	
		if (workout != null) {
			workout.logWorkout();
		}
	}

	public static void UpdateWorkout() {

    ArrayList<Workout> workouts = workoutManager.getWorkouts();
	if (workouts.isEmpty()) {
        System.out.println("No workouts available to update.");
        return;
    }
    Scanner input = new Scanner(System.in);

    System.out.println("Select a workout to update:");
    for (int i = 0; i < workouts.size(); i++) {
        System.out.println((i + 1) + ". " + workouts.get(i).getWorkoutDetails());
    }

    // Get the workout choice from the user
    System.out.println("Enter the number of the workout you want to update: ");
    int workoutChoice = input.nextInt();

    // Validate the workout choice
    if (workoutChoice < 1 || workoutChoice > workouts.size()) {
        System.out.println("Invalid workout number. Please try again.");
        return;
    }

    // Get the selected workout
    Workout selectedWorkout = workouts.get(workoutChoice - 1);

    System.out.println("Select an attribute to update:");
    System.out.println("1. Duration");
    System.out.println("2. Heart Rate");
    System.out.println("3. Intensity");

    // Add workout-specific attributes
    if (selectedWorkout instanceof Swimming) {
        System.out.println("4. Underwater Depth");
        System.out.println("5. Swimming Style");
        System.out.println("6. Laps");
    } else if (selectedWorkout instanceof Cycling) {
        System.out.println("4. Cycling Power");
        System.out.println("5. Cycling Speed");
        System.out.println("6. Cycling Distance");
    } else if (selectedWorkout instanceof Running) {
        System.out.println("4. Speed");
        System.out.println("5. Distance");
    } else if (selectedWorkout instanceof Walking) {
        System.out.println("4. Walk Speed");
        System.out.println("5. Weight");
    } else if (selectedWorkout instanceof Boxing) {
        System.out.println("4. Punches");
        System.out.println("5. Rounds");
    } else if (selectedWorkout instanceof Weightlifting) {
        System.out.println("4. Total Weight Lifted");
        System.out.println("5. Number of Sets");
    }

    // Get the attribute choice from the user
    int attributeChoice = input.nextInt();
    Object newValue = null;

    // Update the selected attribute
    switch (attributeChoice) {
        case 1: // Duration
            System.out.println("Enter new duration (in minutes): ");
            newValue = input.nextDouble();
            selectedWorkout.setDuration((double) newValue);
            break;

        case 2: // Heart Rate
            System.out.println("Enter new heart rate: ");
            newValue = input.nextInt();
            selectedWorkout.setHeartRate((int) newValue);
            break;

        case 3: // Intensity
            System.out.println("Enter new intensity (char): ");
            newValue = input.next().charAt(0);
            selectedWorkout.setIntensity((char) newValue);
            break;

        case 4:
            if (selectedWorkout instanceof Swimming) {
                System.out.println("Enter new underwater depth: ");
                newValue = input.nextDouble();
                ((Swimming) selectedWorkout).setUnderwaterDepth((double) newValue);
            } else if (selectedWorkout instanceof Cycling) {
                System.out.println("Enter new cycling power: ");
                newValue = input.nextDouble();
                ((Cycling) selectedWorkout).setCyclingPower((double) newValue);
            } else if (selectedWorkout instanceof Running) {
                System.out.println("Enter new speed: ");
                newValue = input.nextInt();
                ((Running) selectedWorkout).setSpeed((int) newValue);
            } else if (selectedWorkout instanceof Walking) {
                System.out.println("Enter new walk speed: ");
                newValue = input.nextDouble();
                ((Walking) selectedWorkout).setWalkspeed((double) newValue);
            } else if (selectedWorkout instanceof Boxing) {
                System.out.println("Enter new punches: ");
                newValue = input.nextInt();
                ((Boxing) selectedWorkout).setPunches((int) newValue);
            } else if (selectedWorkout instanceof Weightlifting) {
                System.out.println("Enter new total weight lifted: ");
                newValue = input.nextDouble();
                ((Weightlifting) selectedWorkout).setTotalWeightLifted((double) newValue);
            }
            break;

        case 5:
            if (selectedWorkout instanceof Swimming) {
                System.out.println("Enter new swimming style: ");
                newValue = input.next();
                ((Swimming) selectedWorkout).setSwimwingStyle((String) newValue);
            } else if (selectedWorkout instanceof Cycling) {
                System.out.println("Enter new cycling speed: ");
                newValue = input.nextDouble();
                ((Cycling) selectedWorkout).setCyclingSpeed((double) newValue);
            } else if (selectedWorkout instanceof Running) {
                System.out.println("Enter new distance: ");
                newValue = input.nextInt();
                ((Running) selectedWorkout).setDistance((int) newValue);
            } else if (selectedWorkout instanceof Walking) {
                System.out.println("Enter new weight: ");
                newValue = input.nextDouble();
                ((Walking) selectedWorkout).setWeight((double) newValue);
            } else if (selectedWorkout instanceof Boxing) {
                System.out.println("Enter new rounds: ");
                newValue = input.nextInt();
                ((Boxing) selectedWorkout).setRounds((int) newValue);
            } else if (selectedWorkout instanceof Weightlifting) {
                System.out.println("Enter new number of sets: ");
                newValue = input.nextInt();
                ((Weightlifting) selectedWorkout).setNumberOfSets((int) newValue);
            }
            break;

        case 6:
            if (selectedWorkout instanceof Swimming) {
                System.out.println("Enter new laps: ");
                newValue = input.nextInt();
                ((Swimming) selectedWorkout).setLaps((int) newValue);
            } else if (selectedWorkout instanceof Cycling) {
                System.out.println("Enter new cycling distance: ");
                newValue = input.nextDouble();
                ((Cycling) selectedWorkout).setCyclingDistance((double) newValue);
            }
            break;

        default:
		
            break;
    }

    System.out.println("Workout updated successfully.");
}
	

	public static void SetUpdateFitnessGoals(){
		goal.setUpdateGoals();

	}

	public static void ViewProgress() {
		Scanner input = new Scanner(System.in);
		
		// Ask the user which goals they want to check
		System.out.println("Which goals would you like to check?");
		System.out.println("1 - Daily Goals");
		System.out.println("2 - Weekly Goals");
		System.out.println("3 - Monthly Goals");
	
		int choice = input.nextInt();
		try {	
		switch (choice) {
			case 1:
				goal.checkDailyGoals(workoutManager, diet.getwater(), diet.getFoodItem());
				break;
			case 2:
				goal.checkWeeklyGoals(workoutManager, diet.getwater(), diet.getFoodItem());
				break;
			case 3:
				goal.checkMonthlyGoals(workoutManager, diet.getwater(), diet.getFoodItem());
				break;

			default:
			    throw new InvalidChoiceException("Invalid choice. Please select 1 or 2 or 3");
		}
	}
	catch (InvalidChoiceException e) {
		System.out.println(e.getMessage());
	}
	}
	
	public static void GeneratePerformanceReports() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose report type: 1. Weekly 2. Monthly");
        int reportType = input.nextInt();

        Performance performance = new Performance(workoutManager.getWorkouts(), diet.getwater(), diet.getFoodItem());
		try{
        if (reportType == 1) {
            performance.generateWeeklyReport();
        } else if (reportType == 2) {
            performance.generateMonthlyReport();
        } else {
            throw new InvalidChoiceException("Invalid report type selected.");
        }
	}
	catch (InvalidChoiceException e) {
		System.out.println(e.getMessage());
		}
    }

	public static void logFoodOrWater() {
		Scanner input = new Scanner(System.in);
	
		System.out.println("Choose an option: 1. Log Meal 2. Log Water");
		int choice = input.nextInt();
		try {
		if (choice == 1) {
			System.out.println("Enter meal name: ");
			String mealName = input.next();
			System.out.println("Enter calories: ");
			int calories = input.nextInt();
			System.out.println("Enter protein amount: ");
			double proteins = input.nextDouble();
	
			Dish foodItem = new Dish(mealName, calories, proteins);
			diet.addFoodItem(foodItem);
		} else if (choice == 2) {
			System.out.println("Enter water amount (in liters): ");
			double waterAmount = input.nextDouble();
			HydrationMonitor waterEntry = new HydrationMonitor(waterAmount);
			diet.addWater(waterEntry);
		} else {
			throw new InvalidChoiceException("Invalid choice. Please select 1 or 2.");
		}
	}
	catch (InvalidChoiceException e) {
		System.out.println(e.getMessage());
		}
	}

	
}


