package temperaturesensor;

import java.text.DecimalFormat;

/**
 *
 * @author neeraj poudyal
 * Just a F to C converter or vice versa
 */
public class TemperatureConverter {

    public float CentigradeToFahrenheit(float cent) {
        return (cent * 9 / 5 + 32);
    }

    public float FahrenheitToCentigrade(float fert) {
        return ((fert - 32) * 5 / 9);
    }
}
