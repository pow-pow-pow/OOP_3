package dishes.type_of_dish;

import dishes.Characteristic;
import dishes.Dish;
import dishes.Ingredient;

import java.util.EnumSet;
import java.util.List;

public class Dessert extends Dish {


    public Dessert(String name, int timeToCook, List<Ingredient> ingredients, EnumSet<Characteristic> characteristic) {
        super(name, timeToCook, ingredients, characteristic);
    }
}