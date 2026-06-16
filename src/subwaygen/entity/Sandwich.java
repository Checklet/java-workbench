package subwaygen.entity;

import subwaygen.data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Sandwich {
    public static final int SIX_INCH = 15;
    public static final int FOOTLONG = 30;

    Bread bread;
    Meat meat;
    Cheese cheese;
    List<Topping> toppings = new ArrayList<>();
    List<Seasoning> seasonings = new ArrayList<>();
    Sauce sauce;
    int length;

    private Sandwich() {
    }

    public static Sandwich create() {
        return new Sandwich();
    }

    private Sandwich setFootlong(boolean isFootlong) {
        length = isFootlong ? FOOTLONG : SIX_INCH;
        return this;
    }

    public Sandwich setFootlong() {
        return setFootlong(true);
    }

    public Sandwich setSixInch() {
        return setFootlong(false);
    }

    public Sandwich setBread(String bread) {
        this.bread = new Bread().setName(bread);
        return this;
    }

    public Sandwich setMeat(String meat) {
        this.meat = new Meat().setName(meat);
        return this;
    }

    public Sandwich setCheese(String cheese) {
        this.cheese = new Cheese().setName(cheese);
        return this;
    }

    public Sandwich setToppings(String... toppings) {
        this.toppings = Arrays.stream(toppings).map(s -> new Topping().setName(s)).toList();
        return this;
    }

    public Sandwich addToppping(String topping) {
        this.toppings.add(new Topping().setName(topping));
        return this;
    }

    public Sandwich addToppings(String... toppings) {
        this.toppings.addAll(Arrays.stream(toppings).map(s -> new Topping().setName(s)).toList());
        return this;
    }

    public Sandwich setSeasonings(String... seasonings) {
        this.seasonings = Arrays.stream(seasonings).map(s -> new Seasoning().setName(s)).toList();
        return this;
    }

    public Sandwich setSauce(String sauce) {
        this.sauce = new Sauce().setName(sauce);
        return this;
    }

    public int getCalories() {
        int calories = 0;

        calories += this.bread.getCalories();
        calories += this.meat.getCalories();
        calories += this.cheese.getCalories();
        for (Topping topping : this.toppings) calories += topping.getCalories();
        for (Seasoning seasoning : this.seasonings) calories += seasoning.getCalories();

        if (this.length == FOOTLONG) calories *= 2;
        return calories;
    }

    @Override
    public String toString() {
        return "- Bread -\n\t%s\n- Meat -\n\t%s\n- Cheese -\n\t%s\n- Topping -\n\t%s\n- Seasoning -\n\t%s\n- Sauce -\n\t%s\n\n- Calories -\n\t%d calories\n".formatted(
            bread,
            meat,
            cheese,
            !toppings.isEmpty() ? String.join("\n\t", toppings.stream().map(Topping::toString).toList()) : "none",
            !seasonings.isEmpty() ? String.join("\n\t", seasonings.stream().map(Seasoning::toString).toList()) : "none",
            sauce,
            getCalories()
        );
    }
}
