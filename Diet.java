import java.util.ArrayList;

public class Diet {
    private ArrayList<FoodItem> foodItems;
    private ArrayList<Water> water;


    public Diet(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }


    public int calculateTotalCalories() {
        int totalCalories = 0;
        for (FoodItem item : foodItems) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    public double calculateTotalProteins() {
        double totalProteins = 0;
        for (FoodItem item : foodItems) {
            totalProteins += item.getProteins();
        }
        return totalProteins;
    }
}