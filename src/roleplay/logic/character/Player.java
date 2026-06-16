package roleplay.logic.character;

import roleplay.logic.inventory.Inventory;

import java.io.Serial;
import java.io.Serializable;

public class Player extends Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1030L;

    private Inventory inventory;

    public Player(String name) {
        this.inventory = new Inventory(80);
        super(name);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
