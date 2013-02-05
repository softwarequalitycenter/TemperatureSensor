package temperaturesensor.constants;

/**
 *
 * @author neeraj poudyal
 */
public class ClientConstants {

    public class Direction {

        public static final int cIncreasingDirection = 0x01;
        public static final int cDecreasingDirection = 0x02;
        public static final int cAnyDirection = 0x04;

    }

    public class ThresholdTemperature{
        public static final double cAnyTemperature=-1000000; //impossible
    }
    
    public class UpdateTemperatureChangeRange{
        public static final double cAnyTemperatureChangeRange=-1000000; //impossible
    }
}
