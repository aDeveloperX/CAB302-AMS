package patt.Coffee;
import patt.Coffee.CoffeeFactory;
import java.util.ArrayList;

public class Coffee {
    CoffeeFactory.Type type;
    double cost;
    ArrayList<CoffeeFactory.Ingredient> ingredients;

    public Coffee(ArrayList<CoffeeFactory.Ingredient> ingredients, CoffeeFactory.Type type) {
        this.type = type;
        this.ingredients = ingredients;

        double sum = 0;
        for (CoffeeFactory.Ingredient ingredient : ingredients) {
            if (ingredient.equals(CoffeeFactory.Ingredient.ESPRESSO)) {
                sum += 0.5;
            } else if (ingredient.equals(CoffeeFactory.Ingredient.MILK)) {
                sum += 1.0;
            } else if (ingredient.equals(CoffeeFactory.Ingredient.CHOCOLATE)) {
                sum += 1.5;
            }
        }
        this.cost = sum;

    }


    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return this.type.getPrice();
    }

    public String listIngredients() {
        String string = "";
        for (CoffeeFactory.Ingredient ingredient : ingredients) {
            string += ingredient;
            string += "\n";
        }
        return string;
    }
}