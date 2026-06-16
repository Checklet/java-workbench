package vaml;

import java.util.Collection;
import java.util.Collections;

public class YamlDocument {
    public Collection<YamlNode> nodes = Collections.emptyList();

    public <T> YamlDocument scalar(String key, T value) {
        nodes.add(YamlScalar.of(key, value));
        return this;
    }

    public <T> YamlDocument sequence(String key, T... values) {
        nodes.add(YamlSequence.of(key, values));
        return this;
    }

    public <T> YamlDocument map(String key, YamlNode... children) {
        nodes.add(YamlMap.of(key, children));
        return this;
    }

    public static void main(String[] args) {
        YamlDocument d = new YamlDocument()
            .scalar("name", "Can Cekic")
            .scalar("age", 25)
            .sequence("friends", "Nils Scheib", "Kai Mörgenthaler")
            .map("family", YamlScalar.of("father", "Ali Cekic"), YamlScalar.of("mother", "Silke Cekic"));
    }
}
