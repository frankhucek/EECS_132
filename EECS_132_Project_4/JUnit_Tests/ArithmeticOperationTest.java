package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of ArithmeticOperation class
 * @author Frank Hucek
 */
public class ArithmeticOperationTest {
    
    public ArithmeticOperationTest() {
    }
    
    /**
     * Test of value method, of class ArithmeticOperation.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        State s = new State();
        Variable x = new Variable("x");
        s.update("x",13);
        Number number = new Number(2);
        
        ArithmeticOperation instance = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.ADD,x,number);
        int expResult = 15;
        int result = instance.value(s);
        assertEquals(expResult, result);
        
        ArithmeticOperation instance2 = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.SUB,x,number);
        int expResult2 = 11;
        int result2 = instance2.value(s);
        assertEquals(expResult2, result2);
        
        ArithmeticOperation instance3 = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.MULT,x,number);
        int expResult3 = 26;
        int result3 = instance3.value(s);
        assertEquals(expResult3, result3);
        
        ArithmeticOperation instance4 = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.DIV,x,number);
        int expResult4 = 6;
        int result4 = instance4.value(s);
        assertEquals(expResult4, result4);
        
        ArithmeticOperation instance5 = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.REM,x,number);
        int expResult5 = 1;
        int result5 = instance5.value(s);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of toString method, of class ArithmeticOperation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ArithmeticOperation instance = new ArithmeticOperation(ArithmeticOperation.ArithmeticOperator.ADD,new Number(20), new Number(13));
        String expResult = "20 + 13";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
