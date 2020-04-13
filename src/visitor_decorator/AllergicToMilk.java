package visitor_decorator;

import dishes.Characteristic;
import java.util.List;

import static dishes.Characteristic.CONTAINSDAIRY;
import static dishes.Characteristic.NONE;

public class AllergicToMilk extends VisitorDecorator {

    public AllergicToMilk(Order ord) {
        super(ord);
    }

    @Override
    public List<Characteristic> constraintCharacteristics(){
        List<Characteristic> constr = super.constraintCharacteristics();
        constr.remove(NONE);
        constr.add(CONTAINSDAIRY);
        return constr;
    }
    @Override
    public List<String> constrictedIngredients(){
        List<String> ingr = super.constrictedIngredients();
        ingr.remove("none");
        ingr.add("milk");
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