package Networking;

//See here:
//https://itqna.net/questions/708/how-get-list-devices-connected-network

import Data.Device;
import Data.DeviceKeyWord;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class NetworkPing
{
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

                            //remove possible ".fritz.box" from name, cause sometimes is just gets added
                            String unwantedSuffix = ".fritz.box";//Note the leading dot
                            int suffixIndex = name.lastIndexOf(unwantedSuffix);
                            if(suffixIndex > 0)
                            {
                                name = name.substring(0, suffixIndex);
                            }

                            String type = name;

                            if(address.getHostAddress().contains(name)){
                                //Device does not want to show its name <.<
                                name = "Unkown Device";
                                type = "OTHER";
                            }

                            Device d = new Device(name, DeviceKeyWord.findDeviceType(type), address.getHostAddress(), address);
                            NetworkDevices.getInstance().addDevice(d);
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
