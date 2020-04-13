package dishes.type_of_dish;

import java.util.EnumSet;
import java.util.List;
import dishes.Characteristic;
import dishes.Dish;
import dishes.Ingredient;

public class Salad extends Dish {

    public Salad(String name, int timeToCook, List<Ingredient> ingredients, EnumSet<Characteristic> characteristic) {
        super(name, timeToCook, ingredients, characteristic);
    }
}
