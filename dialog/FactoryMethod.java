package dialog;

import dialog.generics.Dialog;
import dialog.generics.HTMLDialog;
import dialog.generics.WindowsDialog;

public class FactoryMethod {
    public static void main(String[] args){
        Dialog dialog;

        dialog = new WindowsDialog();
        dialog.renderWindow();

        dialog = new HTMLDialog();
        dialog.renderWindow();
    }
    
}
