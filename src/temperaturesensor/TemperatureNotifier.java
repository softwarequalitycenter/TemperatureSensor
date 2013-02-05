package temperaturesensor;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.Enumeration;
import temperaturesensor.constants.ClientConstants;

/**
 *
 * @author neeraj poudyal
 * 1. TemperatureNotifier indirection class is both the first level observer as well as a notifier.
 * First it should be registered to the TemperatureFetcherThread (as an observer)
 * It then updates all the client observers  when the provided temperature value satisfies the client's conditions for updating
 *(If I were to make a free-standing component, I would wrap it around a facade  to make a single call easier)
 *
 * 2. Both Thermometer and TemperatureFetcherThread are  decoupled from clients
 *
 */
public class TemperatureNotifier extends Observable implements Observer {

    private double curTemp;
    private double prevTemp;
    private Vector temperatureUpdator;

    public TemperatureNotifier() {
        temperatureUpdator = new Vector();
    }

    public void update(Observable obj, Object arg) {
        Double resp;
        if (arg instanceof Double) {
            prevTemp = curTemp;
            resp = (Double) arg;
            curTemp = resp.doubleValue();
            System.out.println("\nReceived Response at 1st level observer: " + curTemp);
            Enumeration clientTemperatureUpdatorEnumeration = temperatureUpdator.elements();
            while (clientTemperatureUpdatorEnumeration.hasMoreElements()) {
                //update the clients depending on their update criteria
                ClientTemperatureUpdater updater = (ClientTemperatureUpdater) clientTemperatureUpdatorEnumeration.nextElement();
                if (updater.getClientUpdateConditions() == null) {//no validation rules specified
                    updater.updateClient(curTemp);
                } else {//validate and update
                    Enumeration updateConditionEnumerator = updater.getClientUpdateConditions().elements();
                    while (updateConditionEnumerator.hasMoreElements()) {
                        ClientUpdateCondition clientUpdateCondition = (ClientUpdateCondition) updateConditionEnumerator.nextElement();
                        if ((new ClientUpdateConditionValidator(clientUpdateCondition, curTemp, prevTemp)).validate()) {
                            updater.updateClient(curTemp);
                        }
                    }
                }
            }
        }
    }

    public boolean addClientTemperatureUpdater(ClientTemperatureUpdater updater) {
        return (temperatureUpdator.add(updater));
    }

    public boolean removeClientTemperatureUpdater(ClientTemperatureUpdater updater) {
        return (temperatureUpdator.remove(updater));
    }

    public Vector getClientTemperatureUpdators(){
        return temperatureUpdator;
    }
}
