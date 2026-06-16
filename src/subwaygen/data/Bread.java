package subwaygen.data;

public final class Bread extends Condiment<Bread> {
    public static final String SESAME = "Sesame";
    public static final String ITALIAN = "Italian";
    public static final String HONEY_OAT = "Honey Oat";
    public static final String CHEESE_OREGANO = "Cheese Oregano";
    public static final String WHOLEWHEAT = "Wholewheat";

    public Bread() {

    }

    @Override
    public int getCalories() {
        return switch (name) {
            case SESAME -> Calories.SESAME;
            case ITALIAN -> Calories.ITALIAN;
            case HONEY_OAT -> Calories.HONEY_OAT;
            case CHEESE_OREGANO -> Calories.CHEESE_OREGANO;
            case WHOLEWHEAT -> Calories.WHOLEWHEAT;
            default -> 300;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
