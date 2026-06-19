package roleplay;

import roleplay.logic.character.CharacterBuilder;
import roleplay.logic.character.Player;

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
        Player newPlayer = CharacterBuilder.character("Checkie")
            .attribute("Strength", 4)
            .attribute("Health", 0, val -> val * 5 + 40)
            .item("Map", 2)
            .item("Compass", 2)
            .build();
    }
}
