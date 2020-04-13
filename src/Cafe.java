
import dishes.Dish;
import dishes.GroupDish;
import dishes.Ingredient;
import dishes.type_of_dish.Dessert;
import dishes.type_of_dish.Drink;
import dishes.type_of_dish.Salad;
import dishes.type_of_dish.Soup;
import visitor_decorator.Order;


import java.io.IOException;
import java.util.List;

public class Cafe {
    private List<Dish> menu;
    private List<Ingredient> ingredients;

    public Cafe(List<Dish> menu, List<Ingredient> ingredients) {
        this.menu = menu;
        this.ingredients = ingredients;
    }


    public List<Dish> getMenu() {
        return menu;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void serve(Order order, List<Dish> drinks,
                      List<Dish> salads, List<Dish> desserts, List<Dish> soups) throws IOException {

        System.out.println("This visitor: ");
        System.out.println(order.getTime());
        System.out.println(order.getMoney());
        System.out.println(order.constraintCharacteristics().toString());
        System.out.println(order.constrictedIngredients().toString());
        System.out.println();

        GroupDish lunch = new GroupDish(drinks, salads, desserts, soups);
        System.out.println("LUNCH");
        lunch.getOutGroupDish();
        System.out.println();

        int m = 0;
        int s = 0;
        boolean hasNoRestrictedIngredients = true;
        boolean cafeHasIngredients = false;
        boolean goodToGo = false;

        for (int j = 0; j < order.constrictedIngredients().size(); j++) {
            for (Ingredient item : lunch.getAllIngredients()) {
                if (item.getName().equals(order.constrictedIngredients().get(j))){
                    hasNoRestrictedIngredients = false;
                }
            }
        }


        for(int i = 0; i < lunch.getAllIngredients().size(); i++){
            if(lunch.getAllIngredients().get(i).getAmount() > 0){
                s++;
            }
        }
        if( s == lunch.getAllIngredients().size()-1){
            cafeHasIngredients = true;
        }

        while(goodToGo != true) {
            if ((lunch.getCost() >= order.getMoney()) || (lunch.getTimeToCook() >= order.getTime())
                    || (hasNoRestrictedIngredients != true) ||(cafeHasIngredients == true)) {
                lunch = new GroupDish(drinks, salads, desserts, soups);
                lunch.getOutGroupDish();
                System.out.println();
                m++;
            }else {
                goodToGo = true;
                break;
            }

            if(m == 3){ break;}
        }

        if(goodToGo == true){
            for(int i = 0; i < lunch.getAllIngredients().size(); i++){
                lunch.getAllIngredients().get(i).useIngredient();
            }
            System.out.println("Visitor served");
        }else{
            System.out.println("visitor left");
        }
        //
    }
}