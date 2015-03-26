package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of Number class
 * @author frank
 */
public class NumberTest {
    
    public NumberTest() {
    }
    
    /**
     * Test of value method, of class Number.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Number instance = new Number(13);
        int expResult = 13;
        int result = instance.value(new State());
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Number.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Number instance = new Number(13);
        String expResult = "13";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
