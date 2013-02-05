package temperaturesensor;
import java.util.Observable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author neeraj poudyal
 * Notes for Jason:
 * TemperatureFetcherThread is a thread that continously reads temperature and notifies only the first level observer with crude temperature data
 * Alternatively, if I were making my own Observable instead of using java's built in pattern class,
 * I could  add my own method such as notifyObserver() to notify a single observer directly on conditional basis
 * But java provides hard-coded Observer pattern and does not allow retrieval of the items in the Observers Vector (it is private)
 * This is why a second level indirection is necessary for dispatching conditional (processed) notification to the clients
 *
 */

public class TemperatureFetcherThread extends Observable implements Runnable {

    private ITemperature temp;

    //dependency injection/IoC
    public TemperatureFetcherThread(ITemperature temp) {
        this.temp = temp;
    }

    public void run() {
        while (true) {
            double centigradeTemperature = temp.getTemperature();
            Double response = Double.valueOf(centigradeTemperature);
            setChanged();
            notifyObservers(response);
        }
    }
}
