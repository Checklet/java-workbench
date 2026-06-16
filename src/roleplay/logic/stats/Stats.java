package roleplay.logic.stats;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;

public class Stats extends HashSet<Attribute> implements Serializable {
    @Serial
    private static final long serialVersionUID = 3020L;

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Attribute attribute))
            return false;

        for (Attribute value : this)
            if (value.getName() == attribute.getName())
                return true;

        return false;
    }
}
