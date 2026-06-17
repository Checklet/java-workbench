package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Inventory implements Serializable, Set<Item>, Iterator<Item> {
    @Serial
    private static final long serialVersionUID = 2010L;

    private InventorySlot[] items;
    private int position;
    private int size;
    private int capacity;

    public Inventory(int capacity) {
        this.items = new InventorySlot[20];
        this.capacity = capacity;
    }

    public Inventory() {
        this(60);
    }

    @Override
    public boolean hasNext() {
        return this.position + 1 < this.size;
    }

    @Override
    public Item next() {
        return this.items[++position].getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
         if (!(o instanceof Item i))
             return false;

         for (Item item : this)
             if (item.getName().equals(i.getName()))
                 return true;

         return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return this;
    }

    @Override
    public Object[] toArray() {
        Item[] arr = new Item[this.size];

        for (int i = 0; i < this.size; i++)
            arr[i] = this.items[i].getItem();

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(Item item) {
        if (this.contains(item)) {
            InventorySlot found = this.find(item);

            if (found != null) {
                found.increase();
                return true;
            }

            throw new RuntimeException("List contains item but somehow cannot find it.");
        }

        if (this.size == this.items.length) {
            InventorySlot[] newArr = new InventorySlot[this.size + 20];

            for (int i = 0; i < this.items.length; i++)
                newArr[i] = this.items[i];

            this.items = newArr;
        }

        this.items[this.size++] = new InventorySlot(item);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Item item))
            return false;

        if (!this.contains(item))
            return false;

        for (int i = 0; i < this.size; i++) {
            InventorySlot slot = this.items[i];

            if (slot.getItem().equals(item)) {
                if (slot.decrease())
                    for (int j = i + 1; j < this.size; j++, i++)
                        this.items[i] = this.items[j];

                return true;
            }
        }

        throw new RuntimeException("Item is there but cannot be removed.");

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!(o instanceof Item i))
                return false;

            if (!this.contains(i))
                return false;
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        for (Item item : c)
            if (!this.add(item))
                return false;

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (this.containsAll(c))
            return false;

        for (Object current : c) {
            if (!(current instanceof Item))
                current = null;

            if (!this.contains(current))
                current = null;
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private InventorySlot find(Item item) {
        if (!this.contains(item))
            return null;

        for (InventorySlot slot : this.items)
            if (slot.getItem().getName().equals(item.getName()))
                return slot;

        return null;
    }
}
