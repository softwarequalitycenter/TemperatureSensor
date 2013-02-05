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
public class TemperatureConverterTest {

    public TemperatureConverterTest() {
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
     * Test of CentigradeToFahrenheit method, of class TemperatureConverter.
     */
    @Test
    public void testCentigradeToFahrenheit() {
        System.out.println("CentigradeToFahrenheit");
        float cent = 0.0F;
        TemperatureConverter instance = new TemperatureConverter();
        float expResult = 32.0F;
        float result = instance.CentigradeToFahrenheit(cent);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of FahrenheitToCentigrade method, of class TemperatureConverter.
     */
    @Test
    public void testFahrenheitToCentigrade() {
        System.out.println("FahrenheitToCentigrade");
        float fert = 32.0F;
        TemperatureConverter instance = new TemperatureConverter();
        float expResult = 0.0F;
        float result = instance.FahrenheitToCentigrade(fert);
        assertEquals(expResult, result, 0.0);
    }

}