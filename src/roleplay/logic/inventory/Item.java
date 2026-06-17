package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;

public class Item implements Serializable, Comparable<Item> {
    @Serial
    private static final long serialVersionUID = 2020L;

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Item item) {
        char[] thisName = name.toCharArray();
        char[] otherName = item.name.toCharArray();

        for (int i = 0; i < thisName.length && i < otherName.length; i++) {
            if (thisName[i] > otherName[i])
                return -1;

            else if (thisName[i] < otherName[i])
                return 1;
        }

        return Integer.compare(otherName.length, thisName.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item item))
            return false;

        return this.getName().equals((item.getName()));
    }
}
