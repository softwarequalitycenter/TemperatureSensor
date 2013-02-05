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
public class ClientUpdateConditionValidatorTest {

    public ClientUpdateConditionValidatorTest() {
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
     * Test of validate method, of class ClientUpdateConditionValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ClientUpdateCondition updateCondition =new  ClientUpdateCondition();
        ClientUpdateConditionValidator instance = new ClientUpdateConditionValidator(updateCondition,0,0);
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class ClientUpdateConditionValidator.
     */
    @Test
    public void testValidate_3args() {
        System.out.println("validate");
        ClientUpdateCondition updateCondition = new  ClientUpdateCondition();
        double curVal = 0.0;
        double prevVal = 0.0;
        ClientUpdateConditionValidator instance = new ClientUpdateConditionValidator(updateCondition,curVal,prevVal);
        boolean expResult = true;
        boolean result = instance.validate(updateCondition, curVal, prevVal);
        assertEquals(expResult, result);

        updateCondition.setDirection(temperaturesensor.constants.ClientConstants.Direction.cIncreasingDirection);
        curVal=0.0;
        prevVal=0.5;
        instance = new ClientUpdateConditionValidator(updateCondition,curVal,prevVal);
        expResult = false;
        result = instance.validate(updateCondition, curVal, prevVal);
        assertEquals(expResult, result);

        updateCondition.setDirection(temperaturesensor.constants.ClientConstants.Direction.cDecreasingDirection);
        updateCondition.setThresholdTemp(0.0);
        curVal=0.0;
        prevVal=1.0;
        instance = new ClientUpdateConditionValidator(updateCondition,curVal,prevVal);
        expResult = true;
        result = instance.validate(updateCondition, curVal, prevVal);
        assertEquals(expResult, result);

    }

}