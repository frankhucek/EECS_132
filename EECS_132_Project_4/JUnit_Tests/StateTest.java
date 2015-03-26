package project_4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for State class
 * @author Frank Hucek
 */
public class StateTest {
    
    public StateTest() {
    }
    
    /**
     * Test of update method, of class State.
     */
    @Test
    public void testUpdateAndLookup() {
        System.out.println("update and lookup test");
        String name = "TestingUpdate";
        int value = 13;
        State instance = new State();
        instance.update(name, value);
        assertEquals(13,instance.lookup("TestingUpdate"));
    }
    
}
