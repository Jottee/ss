package week2;

/**
 * Created by jotte on 18-12-16.
 */

public class LampEnum {
    public enum Setting {
        OFF, LOW, MEDIUM, HIGH;
    }

    public Setting setting;

    public LampEnum() {
        setting = Setting.OFF;
    }

    //@ ensures setting == Setting.OFF || setting == Setting.LOW || setting == Setting.MEDIUM || setting == Setting.HIGH;
    /*@ pure */
    public Setting currentSetting() {
        return setting;
    }

    ////@ ensures \old(setting == Setting.OFF) ==> setting == Setting.LOW || Setting.LOW ==> Setting.MEDIUM || Setting.MEDIUM ==> Setting.HIGH || Setting.HIGH ==> Setting.OFF
    public void switchSetting() {
        switch (setting) {
            case OFF:
                setting = Setting.LOW;
                break;
            case LOW:
                setting = Setting.MEDIUM;
                break;
            case MEDIUM:
                setting = Setting.HIGH;
                break;
            case HIGH:
                setting = Setting.OFF;
                break;

        }
    }
}