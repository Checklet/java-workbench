package test.html;

public final class HtmlAttribute {
    String key;
    String value;

    public HtmlAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return " %s=%s".formatted(key, value);
    }
}
