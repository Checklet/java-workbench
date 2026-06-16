package test;

import test.html.*;

public class Program {
    public static void main(String[] args) {
        HtmlElement html = Html.html()
            .append(new HtmlMeta().charset("utf-8"))
            .add(new HtmlBody())
            .append(new HtmlH1("Content"))
            .append(new HtmlH1("Title"))
            .toRoot();

        System.out.println(html);
    }
}
