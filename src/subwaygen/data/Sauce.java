package subwaygen.data;

public final class Sauce extends Condiment<Sauce> {
    public static final String HONEY_MUSTARD = "Honey Mustard";
    public static final String CHIPOTLE = "Chipotle";
    public static final String SWEET_ONION = "Sweet Onion";
    public static final String GARLIC = "Garlic";
    public static final String YOGHURT = "Yoghurt";
    public static final String MAYONNAISE = "Mayonnaise";
    public static final String BARBECUE = "Barbecue";

    @Override
    public int getCalories() {
        return switch (name) {
            case HONEY_MUSTARD -> Calories.HONEY_MUSTARD;
            case CHIPOTLE -> Calories.CHIPOTLE;
            case SWEET_ONION -> Calories.SWEET_ONION;
            case GARLIC -> Calories.GARLIC;
            case YOGHURT -> Calories.YOGHURT;
            case MAYONNAISE -> Calories.MAYONNAISE;
            case BARBECUE -> Calories.BARBECUE;
            default -> 40;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
