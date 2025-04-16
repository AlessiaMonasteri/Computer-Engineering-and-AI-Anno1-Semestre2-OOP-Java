package devices;

import devices.generics.AdvancedRemoteControl;
import devices.generics.Device;
import devices.generics.Radio;
import devices.generics.RemoteControl;
import devices.generics.TV;

public class BridgePatternDemo {
    public static void main(String[] args) {
    Device tv = new TV();
    Device radio = new Radio();
    RemoteControl basicRemoteForTV = new RemoteControl(tv);
    AdvancedRemoteControl advancedRemoteForRadio = new AdvancedRemoteControl(radio);
    System.out.println("Using Basic Remote for TV:");
    basicRemoteForTV.togglePower();
    basicRemoteForTV.volumeUp();
    System.out.println("\nUsing Advanced Remote for Radio:");
    advancedRemoteForRadio.togglePower();
    advancedRemoteForRadio.volumeUp();
    advancedRemoteForRadio.mute();
    }
   }
