package subwaygen.data;

public final class Seasoning extends Condiment<Seasoning> {
    public static final String PEPPER = "Pepper";
    public static final String SALT = "Salt";
    public static final String ROASTED_ONION = "Roasted Onion";

    @Override
    public int getCalories() {
        return switch (name) {
            case PEPPER -> Calories.PEPPER;
            case SALT -> Calories.SALT;
            case ROASTED_ONION -> Calories.ROASTED_ONION;
            default -> 2;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
