
package junit.Uber;

import java.util.Random;

public class Uber {
      private static Random random = new Random();
      private String drivername;
      private String carmodel;
      private static double farerate;
      private double surge;
      long time1;
      long time2;

    public Uber(String carmodel, String driverName) {
        this.drivername = driverName;
        this.carmodel = carmodel;
    }

    public String getDriverName() {
        return this.drivername;
    }

    public String getCarModel() {
        return this.carmodel;
    }

    public static void setRate(double Farerate){
        farerate = Farerate;
    }

    public static double getFareRate() {
        return farerate;
    }

    public void pickup(){
        time1 = System.currentTimeMillis();
    }

    public double setdownPassenger(){
        time2 = System.currentTimeMillis();
        long time = time2 - time1;
        if(this.surge != 0){
            return (time * surge * getFareRate()) / 1000;
        }
          return (time * getFareRate()) / 1000;
    }

    public void setSurge(double surge){
        this.surge = surge;
    }







}
