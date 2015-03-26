package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Comparison Test.
 * @author Frank Hucek
 */
public class ComparisonTest {
    
    public ComparisonTest() {
    }
    
    /**
     * Test of value method, of class Comparison.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        State s = new State();
        
        Comparison instance = new Comparison(Comparison.ComparisonOperator.LT,new Number(5), new Number(3));
        boolean expResult = false;
        boolean result = instance.value(s);
        assertEquals(expResult, result);
        
        Comparison instance2 = new Comparison(Comparison.ComparisonOperator.LTE,new Number(3), new Number(3));
        boolean expResult2 = true;
        boolean result2 = instance2.value(s);
        assertEquals(expResult2, result2);
        
        Comparison instance3 = new Comparison(Comparison.ComparisonOperator.GT ,new Number(5), new Number(3));
        boolean expResult3 = true;
        boolean result3 = instance3.value(s);
        assertEquals(expResult3, result3);
        
        Comparison instance4 = new Comparison(Comparison.ComparisonOperator.GTE,new Number(5), new Number(3));
        boolean expResult4 = true;
        boolean result4 = instance4.value(s);
        assertEquals(expResult4, result4);
        
        Comparison instance5 = new Comparison(Comparison.ComparisonOperator.EQ,new Number(3), new Number(3));
        boolean expResult5 = true;
        boolean result5 = instance5.value(s);
        assertEquals(expResult5, result5);
        
        Comparison instance6 = new Comparison(Comparison.ComparisonOperator.NEQ,new Number(5), new Number(3));
        boolean expResult6 = true;
        boolean result6 = instance6.value(s);
        assertEquals(expResult6, result6);
    }

    /**
     * Test of toString method, of class Comparison.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Comparison instance = new Comparison(Comparison.ComparisonOperator.LT,new Number(5), new Number(3));
        String expResult = "5 < 3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
