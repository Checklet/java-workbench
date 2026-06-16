package test.html;

public class HtmlMeta extends HtmlVoidElement {
    public HtmlMeta() {
        identifier = "meta";
    }

    public HtmlMeta charset(String charset) {
        attribute("charset", charset);
        return this;
    }

    public HtmlMeta add(String meta, String value) {
        attribute(meta, value);
        return this;
    }
}
