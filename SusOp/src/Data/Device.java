package Data;

public class Device
{
    public String name = "Device Name";

    public DeviceType type = DeviceType.OTHER;

    //short powerUsage

    //mac address (maybe hashed)
    //etc.

    public Device(String name, DeviceType type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
