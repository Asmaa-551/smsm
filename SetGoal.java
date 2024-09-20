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
            System.out.println("You Did It!!! ");
		}
	    else{
				System.out.println("Work Harder Next Week ");
			}
        
        if(totalDuration >= durationGoal) {
                ReachGoalD = true ;
                System.out.println("You Did It!!! ");
        }
         else{
                    System.out.println("Work Harder Next Week ");
             }
            }
		
             public void updateWorkoutProgress(WorkOutManager manager, int index, double extraD, int extraC) {
                if (index >= 0 && index < manager.getWorkouts().size()) {
                    Workout workout = manager.getWorkouts().get(index);
                    workout.setDuration(workout.getDuration() + extraD);
                    workout.setCaloriesBurned(workout.getCaloriesBurned() + extraC);
        
                    System.out.println("Updated workout: " + workout.getName());
                    System.out.println("New Duration: " + workout.getDuration() + " minutes");
                    System.out.println("New Calories Burned: " + workout.getCaloriesBurned() + " kcal");
                } else {
                    System.out.println("Invalid workout index.");
                }
            }
        }
		
	


		
		
		
	
	
	

	
	
	



