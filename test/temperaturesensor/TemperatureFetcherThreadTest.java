/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package temperaturesensor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neeraj poudyal
 */
public class TemperatureFetcherThreadTest {

    public TemperatureFetcherThreadTest() {
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
     * Test of run method, of class TemperatureFetcherThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ITemperature thermometer=new Thermometer();
        TemperatureFetcherThread instance = new TemperatureFetcherThread(thermometer);
        //instance.run();
    }

}