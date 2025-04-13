package dialog.generics;

public class HTMLDialog extends Dialog {
    @Override
    Button createButton(){
        return new HTMLButton();
    }
}