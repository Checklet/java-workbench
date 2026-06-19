package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class Inventory implements Serializable, Collection<Item>, Iterator<Item> {
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

    public int getWeight() {
        int weight = 0;

        for (InventorySlot slot : items)
            weight += slot.getWeight();

        return weight;
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
        int count = 0;

        for (InventorySlot slot : items)
            count += slot.getCount();

        return count;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Item))
            return false;

        for (Item item : this)
            if (item.equals(o))
                return true;

        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return this;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        System.arraycopy(this.items, 0, arr, 0, this.size);

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Item item) {
        if (item == null)
            return false;

        if (item.getWeight() + this.getWeight() > this.capacity)
            return false;

        if (!contains(item)) {
            if (this.size == this.items.length) {
                InventorySlot[] arr = new InventorySlot[this.size + 20];
                System.arraycopy(this.items, 0, arr, 0, this.size);
            }

            this.items[this.size++] = new InventorySlot(item);
        } else {
            InventorySlot slot = new InventorySlot(item);
            slot.increase();
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;

        if (!(o instanceof Item item))
            return false;

        if (!this.contains(item))
            return false;

        if (!this.find(item).decrease())
            for (int i = 0; i < this.items.length; i++)
                if (this.items[i].getItem().equals(item))
                    for (int j = i + 1; j < this.items.length; j++, i++)
                        this.items[i] = this.items[j];

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!this.contains(o))
                return false;

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
    public boolean removeAll(Collection<?> c) {
        for (Object o : c)
            if (!this.remove(o))
                return false;

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.items = new InventorySlot[20];
        this.size = 0;
    }

    private InventorySlot find(Item item) {
        if (item == null)
            return null;

        if (!this.contains(item))
            return null;

        for (int i = 0; i < this.items.length; i++)
            if (this.items[i].getItem().equals(item))
                return this.items[i];

        return null;
    }

    private int size(Item item) {
        return this.size(item.getName());
    }

    private int size(String name) {
        int count = 0;

        for (Item item : this)
            if (item.getName().equals(name))
                count++;

        return count;
    }
}
