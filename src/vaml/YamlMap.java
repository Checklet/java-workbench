package vaml;

import java.util.Arrays;
import java.util.Collection;

public class YamlMap extends YamlNode {
    Collection<YamlNode> children;

    private YamlMap(String key, YamlNode... children) {
        super(key);
        this.children = Arrays.asList(children);
    }

    public static <T> YamlNode of(String key, YamlNode... children) {
        return new YamlSequence<>(key, children);
    }
}
