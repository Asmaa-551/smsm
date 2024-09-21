import java.time.LocalDateTime;
import java.util.ArrayList;

public class FoodItem {
    private String mealName;
    private int calories;
    private double proteins;
    private LocalDateTime dateLogged;
    private static ArrayList<FoodItem> FoodItem;


    public FoodItem(String mealName, int calories, double proteins) {
        this.mealName = mealName;
        this.calories = calories;
        this.proteins = proteins;
        this.dateLogged = LocalDateTime.now(); 
    }

    public FoodItem() {
        FoodItem = new ArrayList<>();
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public LocalDateTime getDateLogged() {
        return dateLogged;
    }

    public String getMealName() {
        return mealName;
    }

    public int getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public static void logWaterIntake(FoodItem foodItems) {
        FoodItem.add(foodItems);
        System.out.println("Workout added at " + foodItems.getDateLogged());
    }

    public static ArrayList<FoodItem> getFoodItems() {
        return FoodItem;
    }

    
}