package roleplay.logic.inventory;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class Inventory implements Serializable, Collection<Item>, Iterator<Item> {
    @Serial
    private static final long serialVersionUID = 2010L;

    private Item[] items;
    private int position;
    private int size;
    private int capacity;

    public Inventory(int capacity) {
        this.items = new Item[20];
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
        return this.items[++position];
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

        for (int i = 0; i < this.size; i++)
            arr[i] = this.items[i];

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

        if (this.size == this.items.length) {
            Item[] arr = new Item[this.size + 20];
            System.arraycopy(this.items, 0, arr, 0, this.size);
        }

        this.items[this.size++] = item;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Item item))
            return false;

        int find = this.find(item);
        if (find == -1)
            return false;

        for (int prev = find, over = find + 1; over < this.size; over++, prev++)
            this.items[prev] = this.items[over];

        this.size--;
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
        this.items = new Item[20];
        this.size = 0;
    }

    private int find(Item item) {
        if (item == null)
            return -1;

        if (!this.contains(item))
            return -1;

        for (int i = 0; i < this.items.length; i++)
            if (this.items[i].equals(item))
                return i;

        return -1;
    }
}
