package temperaturesensor;
import temperaturesensor.constants.ClientConstants;
/**
 *
 * @author neeraj poudyal
 * The class is used by the clients to provide their conditions for updating the temperature changes
 * (such as thresholds and ranges or directions for each threshold )
 */


public class ClientUpdateCondition {

    private double thresholdTemp;
    private int direction;
    private double range;

    public int getDirection() {
        return direction;
    }

    public double getThresholdTemp() {
        return thresholdTemp;
    }

    public void setThresholdTemp(double thresholdTemp) {
        this.thresholdTemp = thresholdTemp;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }


    public void ClientUpdateCondition() {//default
        thresholdTemp = ClientConstants.ThresholdTemperature.cAnyTemperature;
        direction = ClientConstants.Direction.cAnyDirection;
        range = ClientConstants.UpdateTemperatureChangeRange.cAnyTemperatureChangeRange;

    }
}
