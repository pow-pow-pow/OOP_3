package dishes.type_of_dish;

import dishes.Dish;
import dishes.Characteristic;
import dishes.Ingredient;

import java.util.EnumSet;
import java.util.List;

public class Soup extends Dish {

    public Soup(String name, int timeToCook, List<Ingredient> ingredients, EnumSet<Characteristic> characteristic) {
        super(name, timeToCook, ingredients, characteristic);
    }
}
