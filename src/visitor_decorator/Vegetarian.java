package visitor_decorator;

import dishes.Characteristic;

import java.util.ArrayList;
import java.util.List;

public class Vegetarian extends VisitorDecorator {

    public Vegetarian(Order ord) {
        super(ord);
    }

    @Override
    public List<Characteristic> constraintCharacteristics(){
        List<Characteristic> constr = super.constraintCharacteristics();
        constr.remove(Characteristic.NONE);
        constr.add(Characteristic.CONTAINSMEAT);
        return constr;
    }
    @Override
    public List<String> constrictedIngredients(){
        List<String> ingr = super.constrictedIngredients();
        ingr.remove("none");
        ingr.add("chicken");
        ingr.add("pork");
        ingr.add("beef");
        return ingr;
    }
    @Override
    public int getTime(){
        int time = super.getTime();
        return time;
    }
    @Override
    public int getMoney(){
        int money = super.getMoney();
        return money;
    }
}
