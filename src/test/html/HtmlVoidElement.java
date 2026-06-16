package test.html;

public abstract class HtmlVoidElement extends HtmlElement {
    @Override
    public String toString() {
        String attributesHtml = "";
        for (HtmlAttribute attribute : attributes) attributesHtml += attribute.toString() + " ";

        return "<%s%s/>".formatted(identifier, attributesHtml);
    }
}
