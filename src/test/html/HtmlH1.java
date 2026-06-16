package test.html;

public class HtmlH1 extends HtmlElement {
    String content;

    public HtmlH1(String content) {
        identifier = "h1";
        this.content = content;
    }

    @Override
    public String toString() {
        return "<h1>%s</h1>".formatted(content);
    }
}
