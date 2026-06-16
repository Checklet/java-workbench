package subwaygen.data;

public final class Topping extends Condiment<Topping> {
    public static final String TOMATO = "Tomato";
    public static final String LETTUCE = "Lettuce";
    public static final String CUCUMBER = "Cucumber";
    public static final String PICKLE = "Pickle";
    public static final String ONION = "Onion";
    public static final String OLIVE = "Olive";
    public static final String ARUGULA = "Arugula";
    public static final String BELL_PEPPER = "Bell pepper";
    public static final String CORN = "Corn";

    @Override
    public int getCalories() {
        return switch (name) {
            case TOMATO -> Calories.TOMATO;
            case LETTUCE -> Calories.LETTUCE;
            case CUCUMBER -> Calories.CUCUMBER;
            case PICKLE -> Calories.PICKLE;
            case ONION -> Calories.ONION;
            case OLIVE -> Calories.OLIVE;
            case ARUGULA -> Calories.ARUGULA;
            case BELL_PEPPER -> Calories.BELL_PEPPER;
            case CORN -> Calories.CORN;
            default -> 4;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
