
import java.util.*;
import java.io.*; 
public class SetGoal {
	private int goalCaloriesBurned;
	private boolean ReachGoalC;
	private double durationGoal;
	private boolean ReachGoalD;
	
	
	public SetGoal(int goalCaloriesBurned, double durationGoal) {
		this.goalCaloriesBurned = goalCaloriesBurned;
		this.durationGoal = durationGoal;	
	}

	
	public int getGoalCaloriesBurned() {
		return goalCaloriesBurned;
	}


	public void setGoalCaloriesBurned(int goalCaloriesBurned) {
		this.goalCaloriesBurned = goalCaloriesBurned;
	}

	public double getDurationGoal() {
		return durationGoal;
	}


	public void setDurationGoal(double durationGoal) {
		this.durationGoal = durationGoal;
	}


	public void checkGoalC() {
		if(goalCaloriesBurned > totalCalories) {
			ReachGoalC = true ;
			System.out.println("You Did It!!! ");
		}
	    else{
				System.out.println("Work Harder Next Week ");
			}
		
	public void checkGoalD(){
		if (durationGoal > duration) {
				ReachGoalD = true;
			}
		
	public static void updateWorkoutProgress() {
		
	}
		
		
		}
	
	}
	

	
	
	

}

