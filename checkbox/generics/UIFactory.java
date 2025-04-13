package checkbox.generics;

import dialog.generics.Button;

public interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}