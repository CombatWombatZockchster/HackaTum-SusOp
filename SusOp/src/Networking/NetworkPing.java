package Networking;

//Stolen from here
//https://itqna.net/questions/708/how-get-list-devices-connected-network

import java.io.IOException;
import java.net.InetAddress;

public class NetworkPing
{
    public static void main(String[] args) throws IOException
    {
        InetAddress localhost = InetAddress.getLocalHost();
        // assume we use ipv4!
        byte[] ip = localhost.getAddress();

        for (int i = 1; i <= 254; i++)
        {
            ip[3] = (byte) i;
            InetAddress address = InetAddress.getByAddress(ip);

            if (address.isReachable(1000))
            {
                System.out.println(address + " machine is on and can be pinged");
            }
            else if (!address.getHostAddress().equals(address.getHostName()))
            {
                System.out.println(address + " machine recognized by a DNSLookup");
            }
            else
            {
                System.out.println(address + " host address and host name are the same, host name cannot be resolved.");
            }
        }
    }
}
