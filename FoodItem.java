import java.time.LocalDateTime;

public class FoodItem {
    private String mealName;
    private int calories;
    private double proteins;
    private LocalDateTime dateLogged;

    public FoodItem(String mealName, int calories, double proteins) {
        this.mealName = mealName;
        this.calories = calories;
        this.proteins = proteins;
        this.dateLogged = LocalDateTime.now(); 
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

    
}