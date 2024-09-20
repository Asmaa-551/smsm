public class SetGoal {
	private int goalCaloriesBurned;
	private boolean ReachGoalC;
	private double durationGoal;
	private boolean ReachGoalD;
	
	public SetGoal(int goalCaloriesBurned, double durationGoal) {
		this.goalCaloriesBurned = goalCaloriesBurned;
		this.durationGoal = durationGoal;	
	}

    public void checkGoals(WorkOutManager manager) {
        int totalCalories = 0;
        double totalDuration = 0;

        for (Workout workout : manager.getWorkouts()) {
            totalCalories += workout.calculateCalories();
            totalDuration += workout.getDuration();
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
		
            public void updateGoal(WorkOutManager manager, int index, int newgoalCaloriesBurned, double newdurationGoal) {
                if (index >= 0 && index < manager.getWorkouts().size()) {
                    this.goalCaloriesBurned = newgoalCaloriesBurned;
                    this.durationGoal = newdurationGoal;
            
                    System.out.println("Calories Updated Goal: " + goalCaloriesBurned + " kcal");
                    System.out.println("Duration Updated Goal: " + durationGoal + " minutes");
                } else {
                    System.out.println("Invalid workout index.");
                }
            }
            
            
        }
		
	


		
		
		
	
	
	

	
	
	



