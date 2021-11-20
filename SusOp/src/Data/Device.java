package Data;

import java.net.InetAddress;
import java.util.Locale;

public class Device
{
    public String name = "Device Name";

    public DeviceType type = DeviceType.OTHER;

    public InetAddress address;

    private static String[] phones = new String[]{"HUAWEI", "SAMSUNG", "IPHONE", "APPLE", "PIXEL"};

    //short powerUsage

    //mac address (maybe hashed)
    //etc.

    public Device(String name, DeviceType type, InetAddress address)
    {
        this.name = name;
        this.type = type;
        this.address = address;
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

        for(String t : phones){
            if(info.contains(t)){
                return DeviceType.PHONE;
            }
        }

        return DeviceType.valueOf("OTHER");
    }
}
