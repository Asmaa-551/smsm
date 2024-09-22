import java.util.ArrayList;

public class Diet {
    private ArrayList<FoodItem> foodItems;
    private ArrayList<Water> water;


    public Diet() {
        this.foodItems = new ArrayList<>();
        this.water = new ArrayList<>();
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
        System.out.println("Food item logged: " + foodItem.getMealName() + ", " + foodItem.getCalories() + " calories.");
    }

    public void addWater(Water waterEntry) {
        water.add(waterEntry);
        System.out.println("Water intake logged: " + waterEntry.getWaterAmount() + " liters.");
    }

    public ArrayList<FoodItem> getFoodItem()
    {
        return foodItems;
    }

    public ArrayList<Water> getwater()
    {
        return water;
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