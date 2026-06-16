package roleplay.logic.character;

import roleplay.logic.stats.Attribute;
import roleplay.logic.stats.Stats;

import java.io.Serial;
import java.io.Serializable;

public abstract class Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1010L;

    private String name;

    private Stats stats;

    public Entity(String name) {
        this.stats = new Stats();
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }
}
