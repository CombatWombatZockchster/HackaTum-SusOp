package Data;

import java.util.Locale;

public abstract class DeviceKeyWord
{
    public static String[] phones = new String[]{"HUAWEI", "SAMSUNG", "IPHONE","APPLE", "PIXEL", "XIAOMI", "REDMI", "Android", "GAlAXY", "M2101K7BNY"};
    public static String[] mobile = new String[]{"iPad", "tablet", "kindle"};
    public static String[] routers = new String[]{"fritzbox", "fritz.box", "Fritz!Box", "Telekom"};
    public static String[] desktop = new String[]{"DESKTOP", "PC", "ubuntu", "mac", "2008", "docker"};
    public static String[] laptop = new String[]{"LAPTOP", "notebook", "ultrabook", "macbook"};
    public static String[] printer = new String[]{"printer", "Inkjet", "Canon", "copy", "SEC"};
    public static String[] bulbs = new String[]{"lamp", "bulb", "hue", "ESP"};

    public static boolean checkForKeyWord(String name, String[] keywords)
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
}