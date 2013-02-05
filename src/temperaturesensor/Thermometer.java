package temperaturesensor;

/**
 *
 * @author neeraj poudyal
 * Notes:
 * 1.Thermometer is a clean class (single responsibility) that just
 * retrieves the current centigrade temperature from the sensor
 *
 * 2.Clients(or their updaters) need to implement observer pattern to update continously, rather than calling this class directly
 *
 * 3.See TemperatureFetcherThread (event source) which continously calls  Thermometer.getTemperature and updates the
 * first tier observer(TemperatureNotifier) with crude temperature data
 * In the second tier, the first tier observer (TemperatureNotifier) will process and notify all the clients ONLY if their updating conditions are met.
 */
public class Thermometer implements ITemperature {

    private double centigradeTemperature;
    private int maxValForRandomization;

    public Thermometer() {
        this.maxValForRandomization = 5;//default
    }

    public void Thermometer(int maxValForRandomization) {
        this.maxValForRandomization = maxValForRandomization;
    }

    public int getMaxValue() {
        return this.maxValForRandomization;
    }

    public double getTemperature() {
        /*
         * Simulating temperature
         * Production would probably be:
         * double centigradeTemperature=SomeDeviceSensor.SenseTemperature()
         * or SensingUtilities.SenseTemperature(SomeDevice);
         */
        centigradeTemperature = DecimalFormatter.roundToOneDecimal((new java.util.Random().nextDouble()) * (new java.util.Random().nextInt(maxValForRandomization)));
        double decimalValue = centigradeTemperature - ((double) ((int) centigradeTemperature));
        if (decimalValue >= 0.3 && decimalValue <= 0.7) {
            centigradeTemperature = (double) (int) centigradeTemperature + 0.5;
        } else if (decimalValue > 0.7) {
            centigradeTemperature = (double) (int) centigradeTemperature + 1;
        } else {
            centigradeTemperature = (double) (int) centigradeTemperature;
        }

        if (centigradeTemperature == 0) { // Need to do this as Java double returns a funny value -0.0 if I multiply 0.0 with -1
            return centigradeTemperature;
        }
        return new java.util.Random().nextInt(2) == 0 ? (centigradeTemperature * (-1)) : centigradeTemperature; //for +/-
    }
}
