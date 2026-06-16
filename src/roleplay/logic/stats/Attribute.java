package roleplay.logic.stats;

import java.io.Serial;
import java.io.Serializable;
import java.util.function.UnaryOperator;

public class Attribute implements Serializable {
    @Serial
    private static final long serialVersionUID = 3010L;

    private String name;
    private int value;
    private UnaryOperator<Integer> translate;

    public Attribute(String name, int value, UnaryOperator<Integer> translate) {
        this.name = name;
        this.value = value;
        this.translate = translate;
    }

    public Attribute(String name, int value) {
        this(name, value, UnaryOperator.identity());
    }

    public Attribute(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return translate.apply(value);
    }
}
