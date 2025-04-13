package checkbox.generics;

import dialog.generics.Button;

public class MacOSButton implements Button {
    @Override
    public void render(){
        System.out.println("Render a button in MacOS style");
    }
    public void onClick(){
        System.out.println("Click event for MacOS button");
    }
}