package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of Assignment Class
 * @author Frank Hucek
 */
public class AssignmentTest {
    
    public AssignmentTest() {
    }
    
    /**
     * Test of execute method, of class Assignment.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        State s = new State();
        Variable x = new Variable("x");
        Assignment instance = new Assignment(x,new Number(13));
        instance.execute(s);
        System.out.println("" + s.lookup("x"));
    }

    /**
     * Test of toString method, of class Assignment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Variable x = new Variable("x");
        Assignment instance = new Assignment(x,new Number(13));
        String expResult = "x := 13;";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringTabbed method, of class Assignment.
     */
    @Test
    public void testToStringTabbed() {
        System.out.println("toStringTabbed");
        int input = 1;
        Variable x = new Variable("x");
        Assignment instance = new Assignment(x,new Number(13));
        String expResult = "\tx := 13;";
        String result = instance.toStringTabbed(1);
        assertEquals(expResult, result);
    }
    
}
