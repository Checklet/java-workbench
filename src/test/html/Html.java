package test.html;

public final class Html extends HtmlElement {
    

    private Html() {
        identifier = "html";
        isRoot = true;
    }

    public static Html html() {
        return new Html();
    }

    @Override
    public HtmlElement toRoot() {
        return this;
    }

    @Override
    public String toString() {
        return "%s\n".formatted(super.toString());
    }
}
