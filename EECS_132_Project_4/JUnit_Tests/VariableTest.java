package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests of Variable class
 * @author frank
 */
public class VariableTest {
    /**
     * Test of toString method, of class Variable.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Variable instance = new Variable("VariableName");
        String expResult = "VariableName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class Variable.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        State s = new State();
        Variable instance = new Variable("VariableName");
        s.update(instance.toString(),13);
        int expResult = 13;
        int result = instance.value(s);
        assertEquals(expResult, result);
        
        System.out.println("value testing 0 case");
        Variable instance2 = new Variable("VariableName2");
        int expResult2 = 0;
        int result2 = instance2.value(s);
        assertEquals(expResult, result);
    }
    
}
