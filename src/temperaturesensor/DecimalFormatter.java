package temperaturesensor;
import java.text.DecimalFormat;
/**
 *
 * @author neeraj poudyal
 * Utility class
 */
public class DecimalFormatter {
    static double roundToOneDecimal(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Double.valueOf(twoDForm.format(d));
    }
}
