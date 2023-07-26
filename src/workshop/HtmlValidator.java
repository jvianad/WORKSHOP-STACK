package workshop;

import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {
    //creamos un validados de tipo stack que reciba como paramatro una cola(queue)
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> stack = new Stack<>();

        //Recorremos las etiquetas HTML de la clase htmltag para ir agregandolas al stack si cumple con
        //las condiciones
        for (HtmlTag tag : tags) {
            if (tag.isOpenTag() || tag.isSelfClosing()) {
                //si encuentra etiqueta de apertura, la agrega al stack
                stack.push(tag);
            } else {
                if (stack.isEmpty()) {
                    // aqui ponemos el html desbalanceado, la etiqueta de cierre no tiene etiqueta de apertura
                    stack.push(tag);
                    return stack;
                }

                HtmlTag lastTag = stack.pop();//la ultima etiqueta creada se elimina

                if (!tag.matches(lastTag)) {
                    // esto es por si la etiqueta de cierre no coincide, verificada con el metodo matches
                    stack.push(lastTag); // agrega la etiqueta que no coincide nuevamente al stack
                    stack.push(tag);
                    return stack;
                }
            }
        }

        //retorna vacio el stack si toco concuerda
        return stack;
    }
}
