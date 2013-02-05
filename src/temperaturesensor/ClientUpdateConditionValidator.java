package temperaturesensor;

import temperaturesensor.constants.ClientConstants;

/**
 *
 * @author neeraj poudyal
 */
public class ClientUpdateConditionValidator {

    private ClientUpdateCondition updatecondition;
    private double currentValue;
    private double previousValue;

    public ClientUpdateConditionValidator(ClientUpdateCondition updatecondition, double curVal, double prevVal) {
        this.updatecondition = updatecondition;
        this.currentValue = curVal;
        this.previousValue = prevVal;
    }

    public boolean validate() {
        return validate(this.updatecondition, this.currentValue, this.previousValue);
    }

    public boolean validate(ClientUpdateCondition updateCondition, double curVal, double prevVal) {
        double curValue = DecimalFormatter.roundToOneDecimal(curVal);//use only one digit after decimal
        double prevValue = DecimalFormatter.roundToOneDecimal(prevVal);
        double threshold = DecimalFormatter.roundToOneDecimal(updateCondition.getThresholdTemp());
        double range = DecimalFormatter.roundToOneDecimal(updateCondition.getRange());
        int direction = updateCondition.getDirection();
        if (threshold != curValue && threshold != ClientConstants.ThresholdTemperature.cAnyTemperature) {
            return false;
        }
        double diffRange = prevValue - curValue;
        if (diffRange < 0) {//increasing values
            if (direction == ClientConstants.Direction.cDecreasingDirection) {
                return false;
            }
            //check range, if less than the minimum stated by the client, return false
            if (((-1 * range) < diffRange) && (range != ClientConstants.UpdateTemperatureChangeRange.cAnyTemperatureChangeRange)) {
                return false;
            }
        } else {//decreasing values
            if (direction == ClientConstants.Direction.cIncreasingDirection) {
                return false;
            }
            if ((range > diffRange) && (range != ClientConstants.UpdateTemperatureChangeRange.cAnyTemperatureChangeRange)) {
                return false;
            }
        }

        return true;
    }
}
