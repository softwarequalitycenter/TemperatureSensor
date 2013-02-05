package temperaturesensor;

import java.util.Observable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Vector;
import java.util.Enumeration;
import static org.junit.Assert.*;

/**
 *
 * @author neeraj poudyal
 */
public class TemperatureNotifierTest {

    public TemperatureNotifierTest() {
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
     * Test of addClientTemperatureUpdater method, of class TemperatureNotifier.
     */
    @Test
    public void testAddClientTemperatureUpdater() {
        System.out.println("addClientTemperatureUpdater");
        ClientTemperatureUpdater updater = new ClientTemperatureUpdater(new Client());
        TemperatureNotifier instance = new TemperatureNotifier();
        boolean expResult = true;
        boolean result = instance.addClientTemperatureUpdater(updater);
        assertEquals(expResult, result);
        Vector v=instance.getClientTemperatureUpdators();
        Enumeration e=v.elements();
        if (!e.hasMoreElements()){
            fail();
        }
    }

    /**
     * Test of removeClientTemperatureUpdater method, of class TemperatureNotifier.
     */
    @Test
    public void testRemoveClientTemperatureUpdater() {
        System.out.println("removeClientTemperatureUpdater");
        ClientTemperatureUpdater updater = new ClientTemperatureUpdater(new Client());
        TemperatureNotifier instance = new TemperatureNotifier();
        boolean expResult = false;
        boolean result = instance.removeClientTemperatureUpdater(updater);
        assertEquals(expResult, result);
        instance.addClientTemperatureUpdater(updater);
        Vector v=instance.getClientTemperatureUpdators();
        Enumeration e=v.elements();
        expResult=true;
        assertEquals(expResult, e.hasMoreElements());
        result=instance.removeClientTemperatureUpdater(updater);
        expResult=true;
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class TemperatureNotifier.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable obj = null;
        Object arg = null;
        TemperatureNotifier instance = new TemperatureNotifier();
        // Need mocks and integration testing here
        // instance.update(obj, arg);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}