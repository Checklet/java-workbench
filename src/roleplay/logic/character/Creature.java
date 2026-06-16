package roleplay.logic.character;

import java.io.Serial;
import java.io.Serializable;

public class Creature extends Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1020L;

    public Creature(String name) {
        super(name);
    }
}
