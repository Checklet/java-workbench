package vaml;

import java.util.Arrays;
import java.util.Collection;

public class YamlSequence<T> extends YamlNode {
    public Collection<T> values;

    public YamlSequence(String key, T... values) {
        super(key);
        this.values = Arrays.asList(values);
    }

    public static <T> YamlNode of(String key, T... values) {
        return new YamlSequence<>(key, values);
    }
}
