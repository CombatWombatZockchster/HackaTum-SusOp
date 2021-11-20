package Data;

import java.net.InetAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;

public class Device
{
    public String name = "Device Name";

    public DeviceType type = DeviceType.OTHER;

    public InetAddress inetAddress;

    public String address;

    private Instant start, end;

    //This is in wattHours
    private double wattage;

    //https://www.umweltbundesamt.de/themen/klima-energie/energieversorgung/strom-waermeversorgung-in-zahlen?sprungmarke=Strommix#Strommix
    // Germany 2020 - 366 Grams per Watt hour
    private static int co2PerWattHour = 366;

    public Device(String name, DeviceType type, String address, InetAddress inetAddress)
    {
        this.name = name;
        this.type = type;
        this.address = address;
        this.inetAddress = inetAddress;
        this.start = Instant.now();
        this.end = end;

        switch(this.type){
            //https://qr.ae/pGm5QF
            case DESKTOP -> this.wattage = 350;
            //https://bestlaptopsventure.com/how-many-watts-does-a-laptop-consume/
            case LAPTOP -> this.wattage = 60;
            //https://slate.com/technology/2012/03/is-charging-your-cell-phone-overnight-a-major-waste-of-energy.html#:~:text=According%20to%20measurements%20from%20Lawrence,and%202.24%20watts%20when%20charged.
            case PHONE -> this.wattage = 3;
            case MOBILE-> this.wattage = 3;
            //https://energyusecalculator.com/electricity_printer.htm#:~:text=An%20average%20ink%2Djet%20which,to%20500%20watts%20when%20printing.
            //In this case we expect the printer to be standby
            case PRINTER-> this.wattage = 5;
            //https://smarterhomeguide.com/do-smart-lights-use-electricity-when-theyre-turned-off/#:~:text=Well%2C%20most%20smart%20bulbs%20operate,would%20a%2060%2Dwatt%20incandescent.
            case LIGHTBULB-> this.wattage = 8;
            //https://www.augsburger-allgemeine.de/geld-leben/Stromverbrauch-fuers-WLAN-So-hoch-sind-die-Stromkosten-fuer-den-WLAN-Router-zu-Hause-id51984876.html
            case ROUTER-> this.wattage = 15;
            //We just guess an average of 6 Watts for other devices as they could be anything from phones to laptops, to ...
            case OTHER-> this.wattage = 6;
            default -> this.wattage = 1;
        }
    }

    public static double getWattHour(double wattage, long seconds){
        return wattage * ((double) seconds / 3600);
    }


    public static double getCO2(double wattHour){
        return(wattHour * co2PerWattHour);
    }

    public Instant getEnd(){
        return end;
    }

    public void refreshTime(){
        this.end = Instant.now();
    }

    public Duration getUpTime(){
        return Duration.between(start, end);
    }

    public long getLifeTime()
    {
        return  Duration.between(start, Instant.now()).toSeconds();
    }

    public String upTimeToString()
    {
        Duration dur = Duration.between(start, Instant.now());

        if(dur.toDays() != 0) {
            return dur.toDays() + " d";
        } else if(dur.toHours() != 0) {
            return dur.toHours() + " h";
        } else if(dur.toMinutes() != 0) {
            return dur.toMinutes() + " m";
        } else {
            return dur.toSeconds() + " s";
        }
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + " Type: " + this.type + " Address: " + this.address;
    }

    public double getWattage() {
        return this.wattage;
    }

}
