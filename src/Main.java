import dishes.Characteristic;
import dishes.Dish;
import dishes.Ingredient;
import dishes.type_of_dish.Dessert;
import dishes.type_of_dish.Drink;
import dishes.type_of_dish.Salad;
import dishes.type_of_dish.Soup;
import visitor_decorator.AllergicToMilk;
import visitor_decorator.AllergicToPeanut;
import visitor_decorator.Order;
import visitor_decorator.Visitor;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Dish> setMenu() throws IOException {
        String str;
        Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuForCafe.txt"));
        List<Dish> menu = new ArrayList<>();

        while (sc.hasNextLine()) {

            str = sc.nextLine();
            String[] words = str.split("\\s");

            if(words[0].equals("drink")) {
                menu.add(new Drink(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }
            if(words[0].equals("soup")) {
                menu.add(new Soup(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }
            if(words[0].equals("dessert")) {
                menu.add(new Dessert(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }
            if(words[0].equals("salad")) {
                menu.add(new Salad(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }
        }
        return menu;
    }

    private static List<Ingredient> splitForIngredients(String str) throws IOException {
        List<Ingredient> ingrMenu = setIngredients();
        List<Ingredient> ingredients = new ArrayList<>();

        String[] words = str.split("--");

        for (int i = 0; i < words.length; i++) {
                for (int m = 0; m < ingrMenu.size(); m++) {
                    if (ingrMenu.get(m).getName().equals(words[i])) {
                        ingredients.add(ingrMenu.get(m));
                    }
                }

        }
        return ingredients;
    }

    public static List<Ingredient> setIngredients() throws IOException {
        String str;
        Scanner scan = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuOfIngredients.txt"));
        List<Ingredient> ingredients = new ArrayList<>();

        while (scan.hasNextLine()) {

            str = scan.nextLine();
            String[] words = str.split("--"); // Разбиение строки на слова с помощью разграничителя (пробел)
            for (int i = 0; i < words.length/3; i++) {

                ingredients.add(new Ingredient(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2])));
            }
        }
        return ingredients;
    }

    private static EnumSet<Characteristic> splitForCharacteristics(String str) {
        EnumSet<Characteristic> charact = EnumSet.noneOf(Characteristic.class);
        charact.add(Characteristic.NONE);
        List<Characteristic> ch = new ArrayList<>();
        ch.add(Characteristic.NONE);

        String[] words = str.split("--");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("FAT")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.FAT);
                charact.add(Characteristic.FAT);
                charact.remove(Characteristic.NONE);
          }
            if (words[i].equals(Characteristic.SWEET.name())) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.SWEET);
                charact.add(Characteristic.SWEET);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("SOUR")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.SOUR);
                charact.add(Characteristic.SOUR);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("CONTAINSDAIRY")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.CONTAINSDAIRY);
                charact.add(Characteristic.CONTAINSDAIRY);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("SALTY")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.SALTY);
                charact.add(Characteristic.SALTY);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("CONTAINSPEANUT")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.CONTAINSPEANUT);
                charact.add(Characteristic.CONTAINSPEANUT);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("CONTAINSCITRUS")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.CONTAINSCITRUS);
                charact.add(Characteristic.CONTAINSCITRUS);
                charact.remove(Characteristic.NONE);
            }
            if (words[i].equals("CONTAINSMEAT")) {
                ch.remove(Characteristic.NONE);
                ch.add(Characteristic.CONTAINSMEAT);
                charact.add(Characteristic.CONTAINSMEAT);
                charact.remove(Characteristic.NONE);
            }
        }
        return charact;
    }

    public static List<Dish> setDrinks() throws IOException {
        String str;
        Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuForCafe.txt"));
        List<Dish> drinks = new ArrayList<>();

        while (sc.hasNextLine()) {

            str = sc.nextLine();
            String[] words = str.split("\\s");

            if(words[0].equals("drink")) {
                drinks.add(new Drink(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }

        }
        return drinks;
    }
    public static List<Dish> setSalads() throws IOException {
        String str;
        Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuForCafe.txt"));
        List<Dish> salads = new ArrayList<>();

        while (sc.hasNextLine()) {

            str = sc.nextLine();
            String[] words = str.split("\\s");

            if(words[0].equals("salad")) {
                salads.add(new Salad(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }

        }
        return salads;
    }
    public static List<Dish> setDesserts() throws IOException {
        String str;
        Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuForCafe.txt"));
        List<Dish> desserts = new ArrayList<>();

        while (sc.hasNextLine()) {

            str = sc.nextLine();
            String[] words = str.split("\\s");

            if(words[0].equals("dessert")) {
                desserts.add(new Dessert(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }

        }
        return desserts;
    }
    public static List<Dish> setSoups() throws IOException {
        String str;
        Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\OOP_3\\src\\menuForCafe.txt"));
        List<Dish> soups = new ArrayList<>();

        while (sc.hasNextLine()) {

            str = sc.nextLine();
            String[] words = str.split("\\s");

            if(words[0].equals("soup")) {
                soups.add(new Soup(words[1], Integer.parseInt(words[2]),
                        splitForIngredients(words[words.length - 2]), splitForCharacteristics(words[words.length - 1])));
            }

        }
        return soups;
    }


    public static void main(String[] args)throws IOException {

        Cafe myCafe = new Cafe(setMenu(),setIngredients());
Order visitor1 = new AllergicToPeanut(new AllergicToMilk(new Visitor(40,350)));
   //     Order visitor1 = new AllergicToMilk(new Visitor(35,350));
        myCafe.serve(visitor1,setDrinks(),setSalads(),setDesserts(),setSoups());
        System.out.println("End");
    }
}
