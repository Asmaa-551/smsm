import java.util.Scanner;

public class ActivePulse {

	private static WorkOutManager workoutManager = new WorkOutManager();
	public static void main(String[] args) {
		int userChoice;
		do {
			DislayMenu();
			userChoice = UserMenuChoice();
			switch (userChoice) {
				case 1: LogNewWorkout(); break; 	
				case 2: UpdateWorkout(); break;	
				case 3: SetUpdateFitnessGoals(); break;	
				case 4: ViewProgress(); break;		
				case 5: GeneratePerformanceReports(); break;	
				case 6: NewExtraFunctionality(); break;	

				default:  System.out.println("Thank You for Using CSC301's ActivePulse (A Personal Fitness Tracker App), Have a Nice Day.");
			}
		}while (userChoice != 0);
	}
	
	public static void DislayMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Personal Fitness Tracker System (ActivePulse, Fall 24-25)");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Log a new workout (Running, Cycling, Weightlifting, Swimming, ...)");
		System.out.println("2. Update workout details (duration, distance, calories, etc.)");
		System.out.println("3. Set or update fitness goals.");
		System.out.println("4. View progress toward goals.");
		System.out.println("5. Generate performance reports (weekly, monthly, etc.)");
		System.out.println("6. Log nutritional intake (meals and water).");
		System.out.println("0. Exit");
		System.out.println("------------------------------------------------------------");
	}

	public static int UserMenuChoice(){
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Your Choice (0, 1, 2, 3, 4, 5, 6):");
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

	public static void UpdateWorkout(){
		// To be completed. Feel free to change the input parameters.  
	}

	public static void SetUpdateFitnessGoals(){
		// To be completed. Feel free to change the input parameters.  
	}

	public static void ViewProgress(){
		// To be completed. Feel free to change the input parameters. 
	}
	
	public static void GeneratePerformanceReports() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose report type: 1. Weekly 2. Monthly");
        int reportType = input.nextInt();

        Performance performance = new Performance(workoutManager.getWorkouts());

        if (reportType == 1) {
            performance.generateWeeklyReport();
        } else if (reportType == 2) {
            performance.generateMonthlyReport();
        } else {
            System.out.println("Invalid report type selected.");
        }
    }

	public static void NewExtraFunctionality(){
		// To be completed. Feel free to change the input parameters. 
	}
}