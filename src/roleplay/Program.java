package roleplay;

import roleplay.logic.character.Player;
import roleplay.logic.inventory.Item;
import roleplay.logic.stats.Attribute;

public final class Program {
    public static boolean isGui = false;
    public static boolean isDebug = false;
    public static boolean isTest = false;

    static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("--gui")) isGui = true;
            if (arg.equals("--debug")) isDebug = true;
            if (arg.equals("--test")) isTest = true;
        }

        if (isGui) new GUI();

        if (isTest) test();
    }

    private static void test() {
        Player player = new Player("Checker");

        player.getStats().add(new Attribute("Strength", 4));
        player.getStats().add(new Attribute("Dexterity", 3));
        player.getStats().add(new Attribute("Intelligence", 7));
        player.getStats().add(new Attribute("Charisma", 5));
        player.getStats().add(new Attribute("Health", 0, val -> val * 5 + 40));

        player.getInventory().add(new Item("Map", 2));
        player.getInventory().add(new Item("Compass", 2));
        player.getInventory().add(new Item("Bandage", 1));


    }
}
