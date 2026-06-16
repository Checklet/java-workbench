package subwaygen.program;

import subwaygen.data.*;
import subwaygen.entity.Sandwich;

public class Program {
    public static void main(String[] args) {
        Sandwich dasBesteSandwich = Sandwich.create()
            .setFootlong()
            .setBread(Bread.CHEESE_OREGANO)
            .setMeat(Meat.CHICKEN_TERIYAKI)
            .setCheese(Cheese.CHEDDAR)
            .setToppings(Topping.LETTUCE, Topping.ARUGULA, Topping.ONION)
            .setSauce(Sauce.BARBECUE);

        System.out.println(dasBesteSandwich);
    }
}
