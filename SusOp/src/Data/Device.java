package Data;

public class Device
{
    public String name = "Device Name";

    //Enum Type
    //short powerUsage

    //mac address (maybe hashed)
    //etc.

    public Device(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
