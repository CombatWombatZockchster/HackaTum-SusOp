package Networking;

import Data.Device;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
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
        if(!containsAddress(this.devices, d.address.toString())){
            //System.out.println("Added Device: " + d.toString());
            this.devices.add(d);
        } else {
            //System.out.println("Already got " + d.toString());
            this.devices.get(getIndexByAddress(this.devices, d.address.toString())).refreshTime();
            //System.out.println(Device.upTimeToString(this.devices.get(getIndexByAddress(this.devices, d.address.toString())).getUpTime()));
        }
    }

    //summe und durchschnitt von Wattage Watthour und Co2

    public double getSumOfWatt(){
        double sum = 0;
        for(Device d: this.devices){
            sum += d.getWattage();
        }
        return sum;
    }

    public double getSumOfWattHour(){
        double sum = 0;
        for(Device d: this.devices){
            sum += Device.getWattHour(d.getWattage(), d.getLifeTime());
        }
        return sum;
    }

    public double getSumOfCo2(){
        double sum = 0;
        for(Device d: this.devices){
            sum += Device.getCO2(Device.getWattHour(d.getWattage(), d.getLifeTime()));
        }
        return sum;
    }

    public double getAvgOfWatt(){
        double sum = 0;
        for(Device d: this.devices){
            sum += d.getWattage();
        }
        return sum / devices.size();
    }

    public double getAvgOfWattHour(){
        double sum = 0;
        for(Device d: this.devices){
            sum += Device.getWattHour(d.getWattage(), d.getLifeTime());
        }
        return sum / devices.size();
    }

    public double getAvgOfCo2(){
        double sum = 0;
        for(Device d: this.devices){
            sum += Device.getCO2(Device.getWattHour(d.getWattage(), d.getLifeTime()));
        }
        return sum / devices.size();
    }


    public void removeOldDevices(){
        for(int d = 0; d < devices.size(); d++){
            if(Duration.between(devices.get(d).getEnd().plus(Duration.ofSeconds(1)), Instant.now()).compareTo(Duration.ofMinutes(1)) > 0) {
                System.out.println(devices.get(d).toString());
                devices.remove(d);
            }
        }
    }

    public ArrayList<Device> getDevices(){
        return this.devices;
    }

    //Do not use contains Name, Unkown Devices get the same Name
    public boolean containsName(final ArrayList<Device> list, final String n){
        return list.stream().filter(o -> o.name.equals(n)).findFirst().isPresent();
    }

    public boolean containsAddress(final ArrayList<Device> list, final String a){
        return list.stream().filter(o -> o.address.toString().equals(a)).findFirst().isPresent();
    }

    public int getIndexByAddress(final ArrayList<Device> list, final String a){
        //From https://newbedev.com/how-to-get-index-of-findfirst-in-java-8

        int[] position = {-1};
        list.stream().peek(x -> position[0]++).filter(o -> o.address.toString().equals(a)).findFirst();
        return position[0];
    }

}
