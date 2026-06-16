package test.html;

import java.util.ArrayList;

public abstract class HtmlElement {
    String identifier;

    ArrayList<HtmlElement> children = new ArrayList<>();
    HtmlElement parent;

    ArrayList<HtmlAttribute> attributes = new ArrayList<>();

    boolean isRoot = false;

    public HtmlElement add(HtmlElement child) {
        children.add(child);
        child.setParent(this);
        return child;
    }

    public HtmlElement append(HtmlElement child) {
        children.add(child);
        return this;
    }

    public HtmlElement attribute(String name, String value) {
        attributes.add(new HtmlAttribute(name, value));
        return this;
    }

    public void setParent(HtmlElement parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String childHtml = "";
        for (HtmlElement child : children) childHtml += child.toString();

        String attributesHtml = "";
        for (HtmlAttribute attribute : attributes) attributesHtml += attribute.toString();

        return "<%s%s>%s</%1$s>".formatted(identifier, attributesHtml, childHtml);
    }

    public HtmlElement toRoot() {
        return parent.toRoot();
    }
}
