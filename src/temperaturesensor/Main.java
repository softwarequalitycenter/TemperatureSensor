package temperaturesensor;
import  temperaturesensor.constants.ClientConstants;

/**
 * @author neeraj poudyal
 * The system is  decoupled  as much as possible
 * Client only has to register itself in TemperatureNotifier after setting up its
 * conditions for notification (eg: threshold, direction, range of change etc.) and it will be notified
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Enter Text >");

        IClient client1 = new Client();
        client1.setName("Client 1");

        //attach client to temperature updater
        ClientTemperatureUpdater clientTemperatureUpdater = new ClientTemperatureUpdater(client1);

        //update conditions 1
        ClientUpdateCondition updateCondition1 = new ClientUpdateCondition();
        updateCondition1.setThresholdTemp(-0.5);//eg: freezing threshold
        updateCondition1.setRange(1);//don't update if the change in temperature is lower than 1 (fluctuating around threshold with value<1)
        updateCondition1.setDirection(ClientConstants.Direction.cAnyDirection);//don't care increasing or decreasing
        clientTemperatureUpdater.addClientUpdateCondition(updateCondition1);

        //update conditions 2
        ClientUpdateCondition updateCondition2 = new ClientUpdateCondition();
        updateCondition2.setThresholdTemp(3);//eg: boiling threshold
        updateCondition2.setRange(ClientConstants.UpdateTemperatureChangeRange.cAnyTemperatureChangeRange);
        updateCondition2.setDirection(ClientConstants.Direction.cIncreasingDirection);
        clientTemperatureUpdater.addClientUpdateCondition(updateCondition2);

        // create an event source with IoC/Dependency Injection
        final TemperatureFetcherThread evSrc = new TemperatureFetcherThread(new Thermometer());

        // create the first level observer 
        final TemperatureNotifier tempNotifier = new TemperatureNotifier();

        // tie updater to the first level observer
        tempNotifier.addClientTemperatureUpdater(clientTemperatureUpdater);

        // subscribe the observer to the event source
        evSrc.addObserver(tempNotifier);

        // starts the temperature event thread
        Thread thread = new Thread(evSrc);
        thread.start();
    }
}
