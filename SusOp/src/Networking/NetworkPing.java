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

        for (int i = 1; i <= 254; i++) {
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

    public static void dummyDevices(){
        new Thread(new Runnable() {
            public void run() {

                try
                {
                    wait(3000);
                }
                catch (Exception e)
                {
                    System.out.println("Crashed Dummy Devices");
                }

                Device d = null;
                try {
                    d = new Device("HP-Printer7256", DeviceKeyWord.findDeviceType("HP-Printer7256"), "192.168.50.87", InetAddress.getByName("192.168.50.87"));
                } catch (UnknownHostException e) {
                    System.out.println("to be expected");
                }
                NetworkDevices.getInstance().addDevice(d);

                try
                {
                    wait(2000);
                }
                catch (Exception e)
                {
                    System.out.println("Crashed Dummy Devices");
                }

                d = null;
                try {
                    d = new Device("HUAWEI-0239", DeviceKeyWord.findDeviceType("HUAWEI-023"), "192.168.50.66", InetAddress.getByName("192.168.50.66"));
                } catch (UnknownHostException e) {
                    System.out.println("to be expected");
                }
                NetworkDevices.getInstance().addDevice(d);

                try
                {
                    wait(5000);
                }
                catch (Exception e)
                {
                    System.out.println("Crashed Dummy Devices");
                }


                d = null;
                try {
                    d = new Device("hue-phillips-1", DeviceKeyWord.findDeviceType("hue-phillips-1"), "192.168.50.73", InetAddress.getByName("192.168.50.73"));
                } catch (UnknownHostException e) {
                    System.out.println("to be expected");
                }
                NetworkDevices.getInstance().addDevice(d);

                d = null;
                try {
                    d = new Device("hue-phillips-2", DeviceKeyWord.findDeviceType("hue-phillips-2"), "192.168.50.74", InetAddress.getByName("192.168.50.74"));
                } catch (UnknownHostException e) {
                    System.out.println("to be expected");
                }
                NetworkDevices.getInstance().addDevice(d);
            }
        }).start();
    }
}
