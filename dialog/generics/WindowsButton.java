package dialog.generics;

public class WindowsButton implements Button {
    @Override
    public void render(){
        System.out.println("Render a button in Windows style");
    }
    public void onClick(){
        System.out.println("Click event for Windows button");
    }
}