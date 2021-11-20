package Networking;

import Data.Device;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NetworkDevices {

    private static final NetworkDevices instance = new NetworkDevices();

    private ArrayList<Device> devices;

    public NetworkDevices(){
        this.devices = new ArrayList<Device>();
    }

    public static NetworkDevices getInstance(){
        return instance;
    }

    public void addDevice(Device d){
        this.devices.add(d);
    }

    public ArrayList<Device> getDevices(){
        return this.devices;
    }

}
