package patt.ReactorMonitoring;
import patt.ReactorMonitoring.RadiationSensor;

public class ControlRoom extends RadiationMonitor {
    private double warningThreshold;
    double radiation;
    private String string;
    /*;
     * Constructs a ControlRoom object, which observes reactor radiation readings
     * and prints reports if the radiation exceeds a threshold.
     *
     * @param location         An arbitrary location.
     * @param warningThreshold The radiation threshold for when reports should be printed.
     */
    public ControlRoom(String location, double warningThreshold) {

        super(location);
        this.string = location;
        this.warningThreshold = warningThreshold;
    }

    /**
     * Updates the monitor with a new observation and prints a report if and only if
     * the observation is equal to or greater than the warning threshold.
     */
    public void update(Subject subject) {

        if(((RadiationSensor)subject).getRadiation() >= warningThreshold){
            radiation = ((RadiationSensor)subject).getRadiation();
            System.out.println(generateReport());
        }
    }

    /**
     * Generates a report based on the current observation.
     */
    @Override
    public String generateReport() {
         String str = "";
         str = now() + " :: WARNING :: " + String.format("%.4f", radiation) + " :: " + string;
         return str;
    }
}