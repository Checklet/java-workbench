package subwaygen.data;

public final class Cheese extends Condiment<Cheese> {
    public static final String CHEDDAR = "Cheddar";
    public static final String AMERICAN = "American";
    public static final String CREAM_CHEESE = "Cream Cheese";
    public static final String VEGAN_CHEESE = "Vegan Cheese";

    @Override
    public int getCalories() {
        return switch (name) {
            case CHEDDAR -> Calories.CHEDDAR;
            case AMERICAN -> Calories.AMERICAN;
            case CREAM_CHEESE -> Calories.CREAM_CHEESE;
            case VEGAN_CHEESE -> Calories.VEGAN_CHEESE;
            default -> 40;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
