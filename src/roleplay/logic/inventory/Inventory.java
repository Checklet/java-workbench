package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;

public class Inventory extends HashSet<Item> implements Serializable {
    @Serial
    private static final long serialVersionUID = 2010L;

    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public Inventory() {
        this(60);
    }

    @Override
    public boolean add(Item item) {
        if (!exceedsCapacity(item.getWeight()))
            return super.add(item);

        return false;
    }

    public int getWeight() {
        int weight = 0;

        for (Item item : this)
            weight += item.getWeight();

        return weight;
    }

    public boolean exceedsCapacity(int weight) {
        return getWeight() + weight > capacity;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Item i)) return false;

        for (Item item : this)
            if (i.getName().equals(item.getName())) return true;

        return false;
    }
}
