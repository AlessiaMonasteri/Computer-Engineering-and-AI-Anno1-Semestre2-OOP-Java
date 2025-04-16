package devices.generics;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 10;
    @Override
    public void powerOn() {
    on = true;
    System.out.println("Radio is now ON.");
    }
    @Override
    public void powerOff() {
    on = false;
    System.out.println("Radio is now OFF.");
    }
    @Override
    public void setVolume(int level) {
    volume = level;
    System.out.println("Radio volume set to " + volume);
    }
    @Override
    public boolean isPoweredOn() {
    return on;
    }
   }
   
