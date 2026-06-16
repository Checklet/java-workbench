package visualnovel.scenes;

import java.util.ArrayList;
import java.util.Arrays;

public class Decision extends ArrayList<Choice> {
    private boolean isDefault = false;

    public Decision(Choice... choices) {
        super(Arrays.asList(choices));
    }

    public Decision(Scene scene) {
        this.isDefault = true;
        this.add(Choice.getDefault(scene));
    }

    public void print() {
        if (isDefault) {
            System.out.println("\t1 – Continue");
        } else {
            System.out.print("\t");
            for (int i = 0; i < this.size(); i++) {
                System.out.printf("%d – %s", i + 1, this.get(i).getText());
                if (i != this.size() - 1) System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
