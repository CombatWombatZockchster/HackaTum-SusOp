package Data;

import java.net.InetAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;

public class Device
{
    public String name = "Device Name";

    public DeviceType type = DeviceType.OTHER;

    public InetAddress inetAddress;

    public String address;

    private static String[] phones = new String[]{"HUAWEI", "SAMSUNG", "IPHONE","APPLE", "PIXEL", "XIAOMI", "REDMI", "Android", "GAlAXY"};
    private static String[] mobile = new String[]{"iPad", "tablet", "kindle"};
    private static String[] routers = new String[]{"fritzbox", "fritz.box", "Fritz!Box", "Telekom"};
    private static String[] desktop = new String[]{"DESKTOP", "PC", "ubuntu", "mac"};
    private static String[] laptop = new String[]{"LAPTOP", "notebook", "ultrabook", "macbook"};
    private static String[] printer = new String[]{"printer", "Inkjet", "Canon", "copy"};
    private static String[] bulbs = new String[]{"lamp", "bulb", "hue"};

    private Instant start, end;

    //short powerUsage

    //mac address (maybe hashed)
    //etc.

    public Device(String name, DeviceType type, String address, InetAddress inetAddress)
    {
        this.name = name;
        this.type = type;
        this.address = address;
        this.inetAddress = inetAddress;
        this.start = Instant.now();
        this.end = Instant.now();
    }

    public void refreshTime(){
        this.end = Instant.now();
    }

    public Duration getUpTime(){
        return Duration.between(start, end);
    }

    public static String upTimeToString(Duration dur){
        if(dur.toDays() != 0) {
            return dur.toDays() + " d";
        } else if(dur.toHours() != 0) {
            return dur.toHours() + " h";
        } else if(dur.toMinutes() != 0) {
            return dur.toMinutes() + " m";
        } else {
            return dur.toSeconds() + " s";
        }
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + " Type: " + this.type + " Address: " + this.address;
    }

    public static DeviceType findDeviceType(String info){
        for (DeviceType t: DeviceType.values()) {
            if(info.contains(t.name()) || info.contains(t.name().toLowerCase(Locale.ROOT))){
                return t;
            }
        }

        if(checkForKeyWord(info, phones)) return DeviceType.PHONE;
        if(checkForKeyWord(info, mobile)) return DeviceType.MOBILE;
        if(checkForKeyWord(info, routers)) return DeviceType.ROUTER;
        if(checkForKeyWord(info, desktop)) return DeviceType.DESKTOP;
        if(checkForKeyWord(info, laptop)) return DeviceType.LAPTOP;
        if(checkForKeyWord(info, printer)) return DeviceType.PRINTER;
        if(checkForKeyWord(info, bulbs)) return DeviceType.LIGHTBULB;


        return DeviceType.valueOf("OTHER");
    }

    private static boolean checkForKeyWord(String name, String[] keywords)
    {
        for(String t : keywords)
        {
            if(name.contains(t) || name.contains(t.toLowerCase()) || name.contains(t.toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }
}
