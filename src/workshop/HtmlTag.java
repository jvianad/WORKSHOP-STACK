package workshop;

public class HtmlTag {
    private String element;
    private boolean isOpenTag;

    public HtmlTag(String element, boolean isOpenTag) {
        this.element = element;
        this.isOpenTag = isOpenTag;
    }

    public String getElement() {
        return element;
    }

    public boolean isOpenTag() {
        return isOpenTag;
    }

    public boolean isSelfClosing() {
        return element.endsWith("/");
    }

    //metodo creado para verificar que la etiqueta de apertura coincida con su respectiva etiqueta de cierre
    public boolean matches(HtmlTag other) {
        if (isOpenTag() && !other.isOpenTag()) {
            return element.equals(other.getElement());
        } else if (!isOpenTag() && other.isOpenTag()) {
            return other.getElement().equals(element);
        }
        return false;
    }
}
