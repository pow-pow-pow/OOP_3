package visitor_decorator;

import dishes.Characteristic;

import java.util.List;

public interface Order {
    List<Characteristic> constraintCharacteristics();
    List<String> constrictedIngredients();
    int getTime();
    int getMoney();
}
