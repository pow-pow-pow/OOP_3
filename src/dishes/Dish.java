package dishes;

import java.util.EnumSet;
import java.util.List;

public class Dish {
    private double cost;
    private int timeToCook;
    private String name;
    private List<Ingredient> ingredients;
    private EnumSet<Characteristic> characteristic;



    public Dish(String name, int timeToCook) {
        this.name = name;
        this.cost = getCostOfIngredients()*1.25 ;
        this.timeToCook = timeToCook;
    }

    public Dish(String name, int timeToCook,List<Ingredient> ingredients,EnumSet<Characteristic> characteristic) {
        this.ingredients = ingredients;
        this.timeToCook = timeToCook;
        this.name = name;
        this.characteristic = characteristic;
        this.cost = getCostOfIngredients()*1.25 ;


    }

    public double getCostOfIngredients(){
        double cost = 0;
        for(Ingredient a : ingredients){
            cost+= a.getCost();
        }
        return cost;
    }


    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }


    public int getTimeToCook() {
        return timeToCook;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public EnumSet<Characteristic> getCharacteristics() {
        return characteristic;
    }
}

