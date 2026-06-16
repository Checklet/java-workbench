package subwaygen.data;

public final class Meat extends Condiment<Meat> {
    public static final String TUNA = "Tuna";
    public static final String SALAMI = "Salami";
    public static final String CHICKEN_TERIYAKI = "Chicken Teriyaki";
    public static final String CHICKEN_FAHITA = "Chicken Fahita";
    public static final String BARBECUE_RIB = "Barbecue Rib";
    public static final String CHICKEN_TANDOORI = "Chicken Tandoori";
    public static final String NACHO_CHICKEN = "Nacho Chicken";
    public static final String PHILLY_BEEF = "Philly Beef";
    public static final String HAM = "Ham";

    @Override
    public int getCalories() {
        return switch (name) {
            case TUNA -> Calories.TUNA;
            case SALAMI -> Calories.SALAMI;
            case CHICKEN_TERIYAKI -> Calories.CHICKEN_TERIYAKI;
            case CHICKEN_FAHITA -> Calories.CHICKEN_FAHITA;
            case BARBECUE_RIB -> Calories.BARBECUE_RIB;
            case CHICKEN_TANDOORI -> Calories.CHICKEN_TANDOORI;
            case NACHO_CHICKEN -> Calories.NACHO_CHICKEN;
            case PHILLY_BEEF -> Calories.PHILLY_BEEF;
            case HAM -> Calories.HAM;
            default -> 450;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
