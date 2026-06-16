package vaml;

public class YamlScalar<T> extends YamlNode {
    public T value;

    private YamlScalar(String key, T value) {
        super(key);
        this.value = value;
    }

    public static <T> YamlNode of(String key, T value) {
        return new YamlScalar<>(key, value);
    }
}
