package temperaturesensor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *  @author neeraj poudyal
 */
public class ThermometerTest {

    public ThermometerTest() {
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
     * Test of getTemperature method, of class Thermometer.
     */
    @Test
    public void testGetTemperature() {
        System.out.println("getTemperature");
        Thermometer instance = new Thermometer();
        int result = instance.getMaxValue();
        if (result<0){
            assertTrue(result>=-5);
        }
        else{
            assertTrue(result<=5);
        }
    }

}