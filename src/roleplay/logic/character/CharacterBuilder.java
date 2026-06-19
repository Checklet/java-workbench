package roleplay.logic.character;

import roleplay.logic.inventory.Item;
import roleplay.logic.stats.Attribute;

import java.util.function.UnaryOperator;

public class CharacterBuilder {
    public Player player;

    private CharacterBuilder() {
    }

    private CharacterBuilder(String name) {
        this.player = new Player(name);
    }

    public static CharacterBuilder character(String name) {
        return new CharacterBuilder();
    }

    public CharacterBuilder item(String name, int weight, int count) {
        for (int i = 0; i < count; i++)
            this.item(name, weight);

        return this;
    }

    public CharacterBuilder item(String name, int weight) {
        return this.item(new Item(name, weight));
    }

    public CharacterBuilder item(Item item) {
        this.player.getInventory().add(item);

        return this;
    }

    public CharacterBuilder attribute(String name, int value, UnaryOperator<Integer> translate) {
        return this.attribute(new Attribute(name, value, translate));
    }

    public CharacterBuilder attribute(String name, int value) {
        return this.attribute(new Attribute(name, value));
    }

    public CharacterBuilder attribute(Attribute att) {
        this.player.getStats().add(att);

        return this;
    }

    public Player build() {
        return this.player;
    }
}
