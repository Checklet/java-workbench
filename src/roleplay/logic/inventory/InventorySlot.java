package roleplay.logic.inventory;

class InventorySlot {
    private Item item;
    private int count;

    InventorySlot(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    InventorySlot(Item item) {
        this(item, 1);
    }

    Item getItem() {
        return item;
    }

    int getCount() {
        return count;
    }

    void increase() {
        ++count;
    }

    boolean decrease() {
        return --count != 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InventorySlot slot))
            return false;

        return this.item.equals(slot.item);
    }
}
