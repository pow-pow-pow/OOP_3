package visitor_decorator;

import dishes.Characteristic;

import java.util.ArrayList;
import java.util.List;

import static dishes.Characteristic.CONTAINSCITRUS;
import static dishes.Characteristic.NONE;

public class AllergicToCitrus extends VisitorDecorator {
    public AllergicToCitrus(Order ord) {
        super(ord);
    }
    @Override
    public List<Characteristic> constraintCharacteristics(){
        List<Characteristic> constr = super.constraintCharacteristics();
        constr.remove(NONE);
        constr.add(CONTAINSCITRUS);
        return constr;
    }
    @Override
    public List<String> constrictedIngredients(){
        List<String> ingr = super.constrictedIngredients();
        ingr.remove("none");
        ingr.add("orange");
        ingr.add("tangerine");
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