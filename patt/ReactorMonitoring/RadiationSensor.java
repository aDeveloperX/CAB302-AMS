package patt.ReactorMonitoring;

import java.text.DecimalFormat;
import java.util.Random;

public class RadiationSensor extends Subject {
     private String location;
    private double radiation;
    private int counter = 0;


    Random random;

    /**
     * Constructs a RadiationSensor object
     *
     * @param location An arbitrary location.
     * @param seed     A seed for the random number generator used to simulate radiation
     *                  readings.
     */
    public RadiationSensor(String location, int seed) {
        this.location = location;
        random = new Random(seed);
    }


    /**
     * Gets the location
     *
     * @return location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Gets the radiation.
     *
     * @return radiation
     */
    public double getRadiation() {
         return this.radiation;
    }

    /**
     * Updates radiation and notifies all observers of
     * the change.
     */

    public int getCounter(){
        return this.counter;
    }
    public void readRadiation() {

        radiation = random.nextDouble()*10;
        counter ++;
        notifyObservers();


    }

}