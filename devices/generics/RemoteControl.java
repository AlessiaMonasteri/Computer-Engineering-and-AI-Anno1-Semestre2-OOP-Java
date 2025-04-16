package devices.generics;

public class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) {
    this.device = device;
    }
    public void togglePower() {
    if (device.isPoweredOn()) {
    device.powerOff();
    } else {
    device.powerOn();
    }
    }
    public void volumeDown() {
    device.setVolume(5);
    }
    public void volumeUp() {
    device.setVolume(15);
    }
   }
   
