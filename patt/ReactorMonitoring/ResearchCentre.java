package patt.ReactorMonitoring;


public class ResearchCentre extends RadiationMonitor {
     private int radi;
     private double radii;
     private String location;

    /**
     * Constructs a ResearchCentre object, which observes reactor radiation readings
     * and constantly prints a report with the current moving average of the
     * recorded observations.
     *
     * @param location An arbitrary location.
     */
    public ResearchCentre(String location) {
        super(location);
        this.location = location;
    }

    /**
     * Updates the monitor with a new observation and prints a report.
     */
    public void update(Subject subject) {
           radi = ((RadiationSensor)subject).getCounter();
           radii += ((RadiationSensor)subject).getRadiation();
           System.out.println(generateReport());
    }

    /**
     * Generates a report of the current moving average, updated by a new
     * observation. The moving average is calculated by summing all observations
     * made so far, and dividing by the quantity of observations so far.
     */
    public String generateReport() {
          String str = "";
          if(radi == 0){
              str = now() + " :: moving average :: " + "0.0000" + " :: " + location;
          }
          else {
              str = now() + " :: moving average :: " + String.format("%.4f", radii/radi) + " :: " + location;
          }

          return str;
    }

}