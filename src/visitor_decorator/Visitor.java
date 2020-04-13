package visitor_decorator;

import dishes.Characteristic;
import dishes.GroupDish;

import java.util.ArrayList;
import java.util.List;

public class Visitor implements Order {

    private int time;
    private int money;
    private List<Characteristic> constraints;
    private List<String> constrictedIgredients;

    public Visitor(int time, int money,List<Characteristic> constraints,List<String> constrictedIgredients) {
        this.time = time;
        this.money = money;
        this.constraints = constraints;
        this.constrictedIgredients = constrictedIgredients;
    }

    public Visitor(int time, int money) {
        this.time = time;
        this.money = money;
        this.constraints = setConstraintCharacteristics();
        this.constrictedIgredients = setConstrictedIngredients();
    }


    @Override
    public List<Characteristic> constraintCharacteristics() {
        return this.constraints;
    }

    @Override
    public List<String> constrictedIngredients() {
        return this.constrictedIgredients;
    }

    @Override
    public int getTime() {
        return this.time;
    }
    @Override
    public int getMoney() {
        return this.money;
    }

    public List<Characteristic> setConstraintCharacteristics() {
        List<Characteristic> constraints = new ArrayList<>();
        constraints.add(Characteristic.NONE);
        return constraints;
    }
    public List<String> setConstrictedIngredients()
    {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("none");
        return ingredients;
    }
}

