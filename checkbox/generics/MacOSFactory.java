package checkbox.generics;

import dialog.generics.Button;

public class MacOSFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckBox();
    }

}