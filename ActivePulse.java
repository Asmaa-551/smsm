import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


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
				case 6: GeneratePerformanceReports(); break;	

				default:  System.out.println("Thank You for Using CSC301's ActivePulse (A Personal Fitness Tracker App), Have a Nice Day.");
			}
		}while (userChoice != 0);
	}
	
	public static void DislayMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Personal Fitness Tracker System (ActivePulse, Fall 24-25)");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Log a new workout (Running, Cycling, Weightlifting, Swimming, ...)");
		System.out.println("2. Log nutritional intake (Meals and Water).");
		System.out.println("3. Update workout details (Duration, Distance, Calories, etc.)");
		System.out.println("4. Set or update fitness goals (Daily, Weekly, Monthly)");
		System.out.println("5. View progress toward goals.");
		System.out.println("6. Generate performance reports (Weekly, Monthly)");
		System.out.println("0. Exit");
		System.out.println("------------------------------------------------------------");
	}

	public static int UserMenuChoice(){
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Your Choice (0, 1, 2, 3, 4, 5, 6):");
			choice = input.nextInt();
			if(choice < 0 || choice > 6) {
				System.out.println("Invalid Choice, Please Try Again.");
			}
		} while(choice > 6);
		return choice;
	}
	
	public static void LogNewWorkout() {
		Scanner input = new Scanner(System.in);
	
		System.out.println("Choose workout type: 1. Walking 2. Running 3. Cycling 4. Swimming 5. Boxing 6. Weightlifting");
		int workoutType = input.nextInt();
	
		Workout workout = null;
	
		int duration = -1;

		while (true) {
			System.out.println("Enter duration (in minutes): ");
			duration = input.nextInt();
			if (duration >= 0) {
				break;
			} else {
				System.out.println("Invalid duration. Please enter a positive number.");
			}
		}
		int heartRate = -1;
		while (true) {
			System.out.println("Enter heart rate (in bpm): ");
			heartRate = input.nextInt();
			if (heartRate > 0) {
				break;
			} else {
				System.out.println("Invalid heart rate. Please enter a positive number.");
			}
		}
		
		char intensity = 'A';  
		while (true) {
			System.out.println("Enter intensity (e.g., A, B, C): ");
			String inputIntensity = input.next().toUpperCase();

			if (inputIntensity.length() == 1) { 
				intensity = inputIntensity.charAt(0); 
				if (intensity == 'A' || intensity == 'B' || intensity == 'C') {
					break;  
				} else {
					System.out.println("Invalid intensity. Please enter 'A', 'B', or 'C'.");
				}
			} else {
				System.out.println("Invalid input. Please enter a single character (A, B, or C).");
			}
		}
	
		switch (workoutType) {
			case 1: // Walking
			double walkSpeed = -1;

			while (true) {
				System.out.println("Enter walk speed (in km/h): ");
				walkSpeed = input.nextDouble();
				if (walkSpeed > 0) {
					break;
				} else {
					System.out.println("Invalid walk speed. Please enter a positive number.");
				}
			}
			double weight = -1;
			while (true) {
				System.out.println("Enter your weight (in kg): ");
				weight = input.nextDouble();
				if (weight > 0) {
					break;
				} else {
					System.out.println("Invalid weight. Please enter a positive number.");
				}
			}
			workout = new Walking(duration, heartRate, intensity, walkSpeed, weight);
			break;

	
			case 2: // Running
			int runningDistance = -1;
			while (true) {
				System.out.println("Enter distance (in kilometers): ");
				runningDistance = input.nextInt();
				if (runningDistance > 0) {
					break;
				} else {
					System.out.println("Invalid distance. Please enter a positive number.");
				}
			}
			
			int speed = -1;
			while (true) {
				System.out.println("Enter speed (in km/h): ");
				speed = input.nextInt();
				if (speed >= 0) {
					break;
				} else {
					System.out.println("Invalid speed. Please enter a positive number.");
				}
			}
			
			workout = new Running(speed, runningDistance, duration, heartRate, intensity);
			break;
	
			case 3: // Cycling
			double cyclingPower = -1;
			while (true) {
				System.out.println("Enter cycling power (in watts): ");
				cyclingPower = input.nextDouble();
				if (cyclingPower > 0) {
					break;
				} else {
					System.out.println("Invalid power. Please enter a positive number.");
				}
			}
			
			double cyclingSpeed = -1;
			while (true) {
				System.out.println("Enter cycling speed (in km/h): ");
				cyclingSpeed = input.nextDouble();
				if (cyclingSpeed > 0) {
					break;
				} else {
					System.out.println("Invalid speed. Please enter a positive number.");
				}
			}
			
			double cyclingDistance = -1;
			while (true) {
				System.out.println("Enter cycling distance (in kilometers): ");
				cyclingDistance = input.nextDouble();
				if (cyclingDistance > 0) {
					break;
				} else {
					System.out.println("Invalid distance. Please enter a positive number.");
				}
			}
			
			workout = new Cycling(duration, heartRate, intensity, cyclingDistance, cyclingPower, cyclingSpeed);
			break;
	
			case 4: // Swimming
			double underwaterDepth = -1;
			while (true) {
				System.out.println("Enter underwater depth (in meters): ");
				underwaterDepth = input.nextDouble();
				if (underwaterDepth >= 0) {  // here we assume that the depth can be zero for some cases
					break;
				} else {
					System.out.println("Invalid depth. Please enter a non-negative number.");
				}
			}
			
			String swimmingStyle;
			while (true) {
				System.out.println("Enter swimming style (freestyle, breaststroke, backstroke, butterfly): ");
				swimmingStyle = input.next();
				if (isValidSwimmingStyle(swimmingStyle)) {
					break;
				} else {
					System.out.println("Invalid swimming style. Please enter a valid style.");
				}
			}
			
			int laps = -1;
			while (true) {
				System.out.println("Enter number of laps: ");
				laps = input.nextInt();
				if (laps > 0) {
					break;
				} else {
					System.out.println("Invalid number of laps. Please enter a positive number.");
				}
			}
			
			workout = new Swimming(duration, heartRate, intensity, underwaterDepth, swimmingStyle, laps);
			break;
	
			case 5: // Boxing
			int punches = -1;
			while (true) {
				System.out.println("Enter number of punches: ");
				punches = input.nextInt();
				if (punches > 0) {
					break;
				} else {
					System.out.println("Invalid number of punches. Please enter a positive number.");
				}
			}
			
			int rounds = -1;
			while (true) {
				System.out.println("Enter number of rounds: ");
				rounds = input.nextInt();
				if (rounds > 0) {
					break;
				} else {
					System.out.println("Invalid number of rounds. Please enter a positive number.");
				}
			}
			
			workout = new Boxing(duration, heartRate, intensity, punches, rounds);
			break;
	
			case 6: // Weightlifting
			double totalWeightLifted = -1;
			while (true) {
				System.out.println("Enter total weight lifted (in kg): ");
				totalWeightLifted = input.nextDouble();
				if (totalWeightLifted > 0) {
					break;
				} else {
					System.out.println("Invalid weight. Please enter a positive number.");
				}
			}
			
			int numberOfSets = -1;
			while (true) {
				System.out.println("Enter number of sets: ");
				numberOfSets = input.nextInt();
				if (numberOfSets > 0) {
					break;
				} else {
					System.out.println("Invalid number of sets. Please enter a positive number.");
				}
			}
			
			workout = new Weightlifting(totalWeightLifted, numberOfSets, duration, heartRate, intensity);
			break;
	
			default:
				System.out.println("Invalid workout type selected.");
				input.next();
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
        System.out.println((i + 1) + ". " + "(Type: " + workouts.get(i).getClass().getSimpleName() + ") " + workouts.get(i).getWorkoutDetails());
    }

    System.out.println("Enter the number of the workout you want to update: ");
    int workoutChoice = input.nextInt();

    try {
        if (workoutChoice < 1 || workoutChoice > workouts.size()) {
            throw new InvalidChoiceException("Invalid workout number. Please select a valid number between 1 and " + workouts.size());
        }

    WorkoutUpdater selectedWorkout = (WorkoutUpdater) workouts.get(workoutChoice - 1);

    System.out.println("Select an attribute to update:");
    System.out.println("1. Duration");
    System.out.println("2. Heart Rate");
    System.out.println("3. Intensity");

	// check what class is the object is an instance of
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

    int attributeChoice = input.nextInt();
    input.nextLine();
    String attributeName = "";

    switch (attributeChoice) {
        case 1: attributeName = "duration"; break;
        case 2: attributeName = "heartrate"; break;
        case 3: attributeName = "intensity"; break;
        case 4:
            if (selectedWorkout instanceof Swimming) attributeName = "underwaterdepth";
            else if (selectedWorkout instanceof Cycling) attributeName = "cyclingpower";
            else if (selectedWorkout instanceof Running) attributeName = "speed";
            else if (selectedWorkout instanceof Walking) attributeName = "walkspeed";
            else if (selectedWorkout instanceof Boxing) attributeName = "punches";
            else if (selectedWorkout instanceof Weightlifting) attributeName = "totalweightlifted";
            break;
        case 5:
            if (selectedWorkout instanceof Swimming) attributeName = "swimmingstyle";
            else if (selectedWorkout instanceof Cycling) attributeName = "cyclingspeed";
            else if (selectedWorkout instanceof Running) attributeName = "distance";
            else if (selectedWorkout instanceof Walking) attributeName = "weight";
            else if (selectedWorkout instanceof Boxing) attributeName = "rounds";
            else if (selectedWorkout instanceof Weightlifting) attributeName = "numberofsets";
            break;
        case 6:
            if (selectedWorkout instanceof Swimming) attributeName = "laps";
            else if (selectedWorkout instanceof Cycling) attributeName = "cyclingdistance";
            break;
        default:
            System.out.println("Invalid attribute selection.");
			input.next();
            return;
    }

    Object newValue = null;
	boolean validInput = false;

	while (!validInput) {
		try {
			System.out.println("Enter the new value for " + attributeName + ": ");
			
			switch (attributeName) {
				case "duration":
				case "underwaterdepth":
				case "cyclingpower":
				case "totalweightlifted":
				case "cyclingspeed":
				case "weight":
				case "walkspeed":
				case "cyclingdistance":
					newValue = input.nextDouble(); 
					if ((double) newValue <= 0) { 
						System.out.println("Invalid input, please enter a positive number.");
					} else {
						validInput = true;
					}
					break;
	
				case "heartrate":
				case "speed":
				case "numberofsets":
				case "laps":
				case "punches":
				case "distance":
					newValue = input.nextInt(); 
					if ((int) newValue <= 0) {
						System.out.println("Invalid input, please enter a positive number.");
					} else {
						validInput = true;
					}
					break;
	
				case "intensity":
					while (true) {
						System.out.println("Enter intensity (A for Low, B for Medium, C for High): ");
						String intensityInput = input.next().toUpperCase();
						char intensity = intensityInput.charAt(0);
						
						if (intensity == 'A' || intensity == 'B' || intensity == 'C') {
							newValue = intensity;
							validInput = true;
							break;
						} else {
							System.out.println("Invalid intensity. Please enter A, B, or C.");
						}
					}
					break;
	
				case "swimmingstyle":
					while (true) {
						System.out.println("Enter swimming style (freestyle, breaststroke, backstroke, butterfly): ");
						String styleInput = input.nextLine();
						if (isValidSwimmingStyle(styleInput)) {
							newValue = styleInput;
							validInput = true; 
							break;
						} else {
							System.out.println("Invalid swimming style. Please enter a valid style (freestyle, breaststroke, backstroke, butterfly).");
						}
					}
					break;
	
				default:
					System.out.println("Unknown attribute: " + attributeName);
					return;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid value for " + attributeName + ".");
			input.nextLine();
		}
		
	}

    try {
        selectedWorkout.updateWorkout(attributeName, newValue);
        System.out.println("Workout updated successfully.");
    } catch (InvalidAttributeException e) {
        System.out.println("Error updating workout: " + e.getMessage());
    }
	} 
	catch (InvalidChoiceException e) {
		System.out.println(e.getMessage());
	}
}


	public static void SetUpdateFitnessGoals(){
		goal.setUpdateGoals();
	}

	public static void ViewProgress() {
		Scanner input = new Scanner(System.in);
		
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
		if (reportType <= 0) { 
			System.out.println("Invalid input, please enter a positive number.");
			input.next();
		}

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
			int calories;
			do {
                calories = input.nextInt();
                if (calories < 0) {
                    System.out.println("Calories cannot be negative. Please enter a positive value.");
                }
            } while (calories < 0);
			System.out.println("Enter protein amount: ");
			double proteins;
			do {
                proteins = input.nextDouble();
                if (proteins < 0) {
                    System.out.println("Protein amount cannot be negative. Please enter a positive value.");
                }
            } while (proteins < 0);
	
			Dish foodItem = new Dish(mealName, calories, proteins);
			diet.addFoodItem(foodItem);
		} else if (choice == 2) {
			System.out.println("Enter water amount (in liters): ");
			double waterAmount ;
			do{
			waterAmount = input.nextDouble();
			if (waterAmount < 0) {
				System.out.println("Water amount cannot be negative. Please enter a positive value.");
			}
		} while (waterAmount < 0);
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

	private static boolean isValidSwimmingStyle(String style) {
		String[] validStyles = {"freestyle", "breaststroke", "backstroke", "butterfly"};
		for (String validStyle : validStyles) {
			if (validStyle.equalsIgnoreCase(style)) {
				return true;
			}
		}
		return false;
	}

	
}

