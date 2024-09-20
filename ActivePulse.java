import java.util.Scanner;

public class ActivePulse {

	private static WorkoutManager workoutManager = new WorkoutManager();
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
	
	public static void LogNewWorkout(){
		// To be completed. Feel free to change the input parameters. 
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