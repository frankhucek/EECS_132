package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of BooleanOperation class
 * @author Frank Hucek
 */
public class BooleanOperationTest {
    
    public BooleanOperationTest() {
    }
    
    /**
     * Test of value method, of class BooleanOperation.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        State s = new State();
        Comparison c1 = new Comparison(Comparison.ComparisonOperator.LT ,new Number(5), new Number(3)); // false
        Comparison c2 = new Comparison(Comparison.ComparisonOperator.LTE,new Number(3), new Number(3)); // true
        Comparison c3 = new Comparison(Comparison.ComparisonOperator.GT ,new Number(5), new Number(3)); // true
        Comparison c4 = new Comparison(Comparison.ComparisonOperator.EQ ,new Number(5), new Number(3)); // false
        
        BooleanOperation instance = new BooleanOperation(BooleanOperation.BooleanOperator.OR, c1, c2);
        boolean expResult = true;
        boolean result = instance.value(s);
        assertEquals(expResult, result);
        
        BooleanOperation instance2 = new BooleanOperation(BooleanOperation.BooleanOperator.AND, c2, c3);
        boolean expResult2 = true;
        boolean result2 = instance2.value(s);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of toString method, of class BooleanOperation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Comparison c2 = new Comparison(Comparison.ComparisonOperator.LTE,new Number(3), new Number(3)); // true
        Comparison c3 = new Comparison(Comparison.ComparisonOperator.GT ,new Number(5), new Number(3)); // true
        BooleanOperation instance = new BooleanOperation(BooleanOperation.BooleanOperator.AND, c2, c3);
        String expResult = "3 <= 3 && 5 > 3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
