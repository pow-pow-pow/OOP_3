package visitor_decorator;

import dishes.Characteristic;

import java.util.List;

public abstract class VisitorDecorator implements Order {
    protected Order ord;


    public VisitorDecorator(Order ord){
        this.ord = ord;
    }

    public List<Characteristic> constraintCharacteristics(){
        List<Characteristic> constr = ord.constraintCharacteristics();
        return constr;
    }

    public List<String> constrictedIngredients(){
        List<String> ingr = ord.constrictedIngredients();
        return ingr;
    }

    public int getTime(){
        int time = ord.getTime();
        return time;
    }
    public int getMoney(){
        int money = ord.getMoney();
        return money;
    }
}
