package patt.Coffee;

import java.util.ArrayList;

public class CoffeeFactory {

    public static enum Type {
        LONG_BLACK(4.0),
        FLAT_WHITE(4.75),
        MOCHA(5.5);

        private double price;

        Type(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    public static enum Ingredient {
        ESPRESSO(0.5),
        MILK(1),
        CHOCOLATE(1.5);

        private double cost;

        Ingredient(double cost) {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }
    }

    public static Coffee CreateCoffee(Type type) {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        Coffee coffee;
        if(type == Type.FLAT_WHITE){
            ingredients.add(Ingredient.ESPRESSO);
            ingredients.add(Ingredient.MILK);
        }else if(type == Type.LONG_BLACK){
            ingredients.add(Ingredient.ESPRESSO);
            ingredients.add(Ingredient.ESPRESSO);
        }else if(type == Type.MOCHA){
            ingredients.add(Ingredient.ESPRESSO);
            ingredients.add(Ingredient.MILK);
            ingredients.add(Ingredient.CHOCOLATE);
        }
        coffee = new Coffee(ingredients, type);
        return coffee;

    }
}