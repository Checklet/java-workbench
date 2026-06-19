package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;

class InventorySlot implements Serializable {
    @Serial
    private static final long serialVersionUID = 2030L;

    private Item item;
    private int count;

    InventorySlot(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    InventorySlot(Item item) {
        this(item, 1);
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return this.item.getWeight() * this.count;
    }

    public boolean increase() {
        count++;
        return true;
    }

    public boolean decrease() {
        count--;
        return count > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InventorySlot slot))
            return false;

        return slot.getItem().equals(this.item);
    }
}
