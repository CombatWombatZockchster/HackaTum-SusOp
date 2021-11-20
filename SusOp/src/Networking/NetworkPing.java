package Networking;

//See here:
//https://itqna.net/questions/708/how-get-list-devices-connected-network

import Data.Device;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class NetworkPing
{
    public static void main(String[] args) throws IOException
    {
        try{
            getAllDevices();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public static void getAllDevices() throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        byte[] ip = localhost.getAddress();

        for (int i = 0; i <= 254; i++) {
            final int m = i;
            new Thread(new Runnable() {
                public void run() {
                    ip[3] = (byte) m;
                    try{
                        InetAddress address = InetAddress.getByAddress(ip);
                        if (address.isReachable(1000)) {
                            String name = address.getHostName();
                            String type = name;
                            if(address.getHostAddress().contains(name)){
                                //Device does not want to show its name <.<
                                name = "Unkown Device";
                                type = "OTHER";
                            }
                            Device d = new Device(name, Device.findDeviceType(type), address);
                            NetworkDevices.getInstance().addDevice(d);
                            System.out.println(d);
                            //Mac doesnt work outside of our Broadcast
                            //NetworkInterface ni = NetworkInterface.getByInetAddress(address);
                        } else if (!address.getHostAddress().equals(address.getHostName())) {
                            //Device not pingable
                        } else {
                            //No Device
                        }
                    } catch(Exception e){
                        System.out.println(e.toString());
                    }
                }
            }).start();
        }
    }
}
