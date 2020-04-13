package dishes;

public class Ingredient {
    private String name;
    private double cost;
    private int amount;

    public Ingredient(String name) {
        this.name = name;

    }

    public Ingredient(String name, double cost, int amount) {
        this.name = name;

        this.cost = cost;
        this.amount = amount;
    }

    public void useIngredient() {
        this.amount--;
    }

    public int getAmount() {
        return amount;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
