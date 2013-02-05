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
public class DecimalFormatterTest {

    public DecimalFormatterTest() {
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
     * Test of roundToOneDecimal method, of class DecimalFormatter.
     */
    @Test
    public void testRoundToOneDecimal() {
        System.out.println("roundToOneDecimal");
        double d = 12.22222;
        double expResult =12.2;
        double result = DecimalFormatter.roundToOneDecimal(d);
        assertEquals(expResult, result, 0.0);
    }

}