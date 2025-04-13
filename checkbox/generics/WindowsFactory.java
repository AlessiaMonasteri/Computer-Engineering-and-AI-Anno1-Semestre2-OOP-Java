package checkbox.generics;

import dialog.generics.Button;
import dialog.generics.WindowsButton;

public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton(){
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox(){
        return new WindowsCheckBox();
    }
}