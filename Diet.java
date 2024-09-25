import java.util.ArrayList;

public class Diet {
    private ArrayList<Dish> foodItems;
    private ArrayList<HydrationMonitor> water;


    public Diet() {
        this.foodItems = new ArrayList<>();
        this.water = new ArrayList<>();
    }

    // add a new dish object to the list of food items 
    public void addFoodItem(Dish foodItem) {
        foodItems.add(foodItem);
        System.out.println("Food item logged: " + foodItem.getMealName() + ", " + foodItem.getCalories() + " calories" +  ", " + foodItem.getProteins() + " grams of protein.");
    }

    public void addWater(HydrationMonitor waterEntry) {
        water.add(waterEntry);
        System.out.println("Water intake logged: " + waterEntry.getWaterAmount() + " liters.");
    }
    

    public ArrayList<Dish> getFoodItem()
    {
        return foodItems;
    }

    public ArrayList<HydrationMonitor> getwater()
    {
        return water;
    }


    // It is to figure out how many calories are in each food item
    public int calculateTotalCalories() {
        int totalCalories = 0;
        for (Dish item : foodItems) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    public double calculateTotalProteins() {
        double totalProteins = 0;
        for (Dish item : foodItems) {
            totalProteins += item.getProteins();
        }
        return totalProteins;
    }
}