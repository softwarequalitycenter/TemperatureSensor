package temperaturesensor;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Enumeration;
import static org.junit.Assert.*;

/**
 *
 * @author neeraj poudyal
 */
public class ClientTemperatureUpdaterTest {

    public ClientTemperatureUpdaterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of addClientUpdateCondition method, of class ClientTemperatureUpdater.
     */
    @Test
    public void testAddClientUpdateCondition() {
        System.out.println("addClientUpdateCondition");
        ClientUpdateCondition updateCondition = new ClientUpdateCondition();
        Client client=new Client();
        ClientTemperatureUpdater instance = new ClientTemperatureUpdater(client);
        boolean expResult = true;
        boolean result = instance.addClientUpdateCondition(updateCondition);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeClientUpdateCondition method, of class ClientTemperatureUpdater.
     */
    @Test
    public void testRemoveClientUpdateCondition() {
        System.out.println("removeClientUpdateCondition");
        ClientUpdateCondition updateCondition = new ClientUpdateCondition();
        Client client=new Client();
        ClientTemperatureUpdater instance = new ClientTemperatureUpdater(client);
        instance.addClientUpdateCondition(updateCondition);
        boolean expResult = true;
        boolean result = instance.removeClientUpdateCondition(updateCondition);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientUpdateConditions method, of class ClientTemperatureUpdater.
     */
    @Test
    public void testGetClientUpdateConditions() {
        System.out.println("getClientUpdateConditions");
        ClientUpdateCondition updateCondition1 = new ClientUpdateCondition();
        ClientUpdateCondition updateCondition2 = new ClientUpdateCondition();
        Client client=new Client();
        ClientTemperatureUpdater instance = new ClientTemperatureUpdater(client);
        instance.addClientUpdateCondition(updateCondition1);
        instance.addClientUpdateCondition(updateCondition2);
        Vector expResult = null;
        Vector result = instance.getClientUpdateConditions();
        Enumeration e=result.elements();
        while(e.hasMoreElements()){
          if (! (e.nextElement() instanceof ClientUpdateCondition) )  
              fail();
        }
    }

    /**
     * Test of updateClient method, of class ClientTemperatureUpdater.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("updateClient");
        double value = 0.0;
        ClientUpdateCondition updateCondition = new ClientUpdateCondition();
        Client client=new Client();
        ClientTemperatureUpdater instance = new ClientTemperatureUpdater(client);
        instance.updateClient(value);
    }

}