package temperaturesensor;
import java.util.Vector;

/**
 *
 * @author neeraj poudyal
 * This is not a decorator,just an indirection with IoC for  updating the clients
 * so the Client class can be free of the extra functionality
 * 
 */
public  class ClientTemperatureUpdater  {

    private IClient client;
    private Vector conditions;

    public ClientTemperatureUpdater(IClient client) {
        this.client = client;
        this.conditions = new Vector();
    }

    public void updateClient(double value) {
        System.out.println("\nNewly updated value  for client " + this.client.getName() +" is " + value);
    }

    public boolean addClientUpdateCondition(ClientUpdateCondition updateCondition) {
        return (conditions.add(updateCondition));
    }

    public boolean removeClientUpdateCondition(ClientUpdateCondition updateCondition) {
        return (conditions.remove(updateCondition));
    }

    protected Vector getClientUpdateConditions(){
        return this.conditions;
    }
}
