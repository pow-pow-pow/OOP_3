package dishes;

import dishes.type_of_dish.Dessert;
import dishes.type_of_dish.Drink;
import dishes.type_of_dish.Salad;
import dishes.type_of_dish.Soup;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GroupDish {
    private List<Dish> dishesInGroup;
    private double cost;
    private int timeToCook;
    private double discount;

    public GroupDish(List<Dish> drinks,List<Dish> salads, List<Dish> desserts, List<Dish> soups)  {

        ArrayList<Dish> group = new ArrayList();
        double percentOfDisc;

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(drinks.size());
        Dish chosenDrink = drinks.get(index);

        index = randomGenerator.nextInt(salads.size());
        Dish chosenSalad = salads.get(index);

        index = randomGenerator.nextInt(soups.size());
        Dish chosenSoup = soups.get(index);

        index = randomGenerator.nextInt(desserts.size());
        Dish chosenDessert = desserts.get(index);

        group.add(chosenDrink);
        group.add(chosenSalad);
        group.add(chosenSoup);
        group.add(chosenDessert);

        this.dishesInGroup = group;
        percentOfDisc = Math.random();
        this.discount=percentOfDisc;
        this.cost=(chosenDrink.getCost()+chosenDessert.getCost()+chosenSalad.getCost()+chosenSoup.getCost())*(1-this.discount);
        this.timeToCook=chosenDrink.getTimeToCook()+chosenDessert.getTimeToCook()+chosenSalad.getTimeToCook()
                +chosenSoup.getTimeToCook();

    }


    public double getCost() {
        return cost;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingr = new ArrayList<>();
        for(int a=0; a<dishesInGroup.get(0).getIngredients().size(); a++){
            ingr.add(dishesInGroup.get(0).getIngredients().get(a));
        }
        for(int a=0; a<dishesInGroup.get(1).getIngredients().size(); a++){
            ingr.add(dishesInGroup.get(1).getIngredients().get(a));
        }
        for(int a=0; a<dishesInGroup.get(2).getIngredients().size(); a++){
            ingr.add(dishesInGroup.get(2).getIngredients().get(a));
        }
        for(int a=0; a<dishesInGroup.get(3).getIngredients().size(); a++){
            ingr.add(dishesInGroup.get(3).getIngredients().get(a));
        }
        return ingr;
    }

    public void getOutGroupDish(){
        for(Dish a:dishesInGroup){
            System.out.println(a.getName());
        }
        System.out.println("Cost:"+String.format("%.2f",this.cost));
        System.out.println("Discount:"+String.format("%.2f",this.discount*100)+" %");
        System.out.println("Time to cook:"+this.timeToCook+" min");
    }
}