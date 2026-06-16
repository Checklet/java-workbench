package vaml;

public abstract class YamlNode {
    public String key;

    protected YamlNode(String key) {
        this.key = key.toLowerCase();
    }
}
