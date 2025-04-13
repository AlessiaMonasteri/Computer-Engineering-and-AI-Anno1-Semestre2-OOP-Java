package checkbox;

import checkbox.generics.Checkbox;
import checkbox.generics.MacOSFactory;
import checkbox.generics.UIFactory;
import checkbox.generics.WindowsFactory;
import dialog.generics.Button;

public class AbstractFactory {
    public static void main(String[] args) {
        UIFactory factory;

        factory = new WindowsFactory();
        Button WindowsButton = factory.createButton();
        Checkbox WindowsCheckBox = factory.createCheckbox();
        WindowsButton.render();
        WindowsCheckBox.check();

        factory = new MacOSFactory();
        Button MacOSButton = factory.createButton();
        Checkbox MacOSCheckBox = factory.createCheckbox();
        MacOSButton.render();
        MacOSCheckBox.check();
    }
}
