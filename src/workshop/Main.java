package workshop;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // EJEMPLO 1: html balanceado debe retornar vacio, en este caso well formated
        Queue<HtmlTag> htmlTags1 = new LinkedList<>();
        htmlTags1.add(new HtmlTag("html", true));
        htmlTags1.add(new HtmlTag("body", true));
        htmlTags1.add(new HtmlTag("h1", true));
        htmlTags1.add(new HtmlTag("h1", false));
        htmlTags1.add(new HtmlTag("p", true));
        htmlTags1.add(new HtmlTag("p", false));
        htmlTags1.add(new HtmlTag("body", false));
        htmlTags1.add(new HtmlTag("html", false));

        Stack<HtmlTag> result1 = HtmlValidator.isValidHtml(htmlTags1);
        if (result1.isEmpty()) {
            System.out.println("Example 1: HTML is well formatted.");
        } else {
            System.out.println("Example 1: HTML is NOT well formatted.");
            while (!result1.isEmpty()) {
                HtmlTag unbalancedTag = result1.pop();
                System.out.println("Unbalanced tag: <" + unbalancedTag.getElement() + ">");
            }
        }
        System.out.println();
        // EJEMPLO 2: html balanceado retorna vacio, en este caso well formated
        Queue<HtmlTag> htmlTags2 = new LinkedList<>();
        htmlTags2.add(new HtmlTag("div", true));
        htmlTags2.add(new HtmlTag("p", true));
        htmlTags2.add(new HtmlTag("span", true));
        htmlTags2.add(new HtmlTag("span", false));
        htmlTags2.add(new HtmlTag("p", false));
        htmlTags2.add(new HtmlTag("div", false));

        Stack<HtmlTag> result2 = HtmlValidator.isValidHtml(htmlTags2);
        if (result2.isEmpty()) {
            System.out.println("Example 2: HTML is well formatted.");
        } else {
            System.out.println("Example 2: HTML is NOT well formatted.");
            while (!result2.isEmpty()) {
                HtmlTag unbalancedTag = result2.pop();
                System.out.println("Unbalanced tag: <" + unbalancedTag.getElement() + ">");
            }
        }
        System.out.println();
        // EJEMPLO 3: html desbalanceado, debe retornar not well balanced con la etiqueta que no lo esta
        Queue<HtmlTag> htmlTags3 = new LinkedList<>();
        htmlTags3.add(new HtmlTag("p", true));
        htmlTags3.add(new HtmlTag("span", true));
        htmlTags3.add(new HtmlTag("div", true));
        htmlTags3.add(new HtmlTag("div", false));
        htmlTags3.add(new HtmlTag("span", false));

        Stack<HtmlTag> result3 = HtmlValidator.isValidHtml(htmlTags3);
        if (result3.isEmpty()) {
            System.out.println("Example 3: HTML is well formatted.");
        } else {
            System.out.println("Example 3: HTML is NOT well formatted.");
            while (!result3.isEmpty()) {
                HtmlTag unbalancedTag = result3.pop();
                System.out.println("Unbalanced tag: <" + unbalancedTag.getElement() + ">");
            }
        }
    }
}
