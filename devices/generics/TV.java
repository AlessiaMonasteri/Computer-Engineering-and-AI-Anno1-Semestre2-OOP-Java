package devices.generics;

public class TV implements Device {
    private boolean on = false;
    private int volume = 10;
    @Override
    public void powerOn() {
    on = true;
    System.out.println("TV is now ON.");
    }
    @Override
    public void powerOff() {
    on = false;
    System.out.println("TV is now OFF.");
    }
    @Override
    public void setVolume(int level) {
    volume = level;
    System.out.println("TV volume set to " + volume);
    }
    @Override
    public boolean isPoweredOn() {
    return on;
    }
   }