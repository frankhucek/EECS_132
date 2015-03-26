/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.util.Comparator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test for Contact class.
 * @author Frank Hucek
 */
public class ContactTest
{

    /**
     * Test of equals method, of class Contact.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Contact instance = new Contact("Frank", "8473404364", "fjh32@case.edu");
        Contact instance2 = new Contact("Frank", "8473404364", "fjh32@case.edu");
        Contact instance3 = new Contact("Mike", "8476691088", "mike@gmail");
        
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        boolean expResult2 = false;
        boolean result2 = instance.equals(instance3);
        assertEquals(expResult2,result2);
    }

    /**
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Contact instance = new Contact("Frank","1234","frank@case");
        String expResult = "Frank";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComparatorByTrait method, of class Contact.
     */
    @Test
    public void testGetComparatorByTrait()
    {
        System.out.println("getComparatorByTrait");
        Contact instance = new Contact("Frank","1234","frank@case");
        Contact instance2 = new Contact("Frank", "8473404364", "fjh32@case.edu");
        Contact instance3 = new Contact("Mike", "8476691088", "mike@gmail");
        
        Comparator<Contact> c = instance.getComparatorByTrait("name");
        assertTrue(c.compare(instance, instance2) == 0);
        
        Comparator<Contact> c2 = instance2.getComparatorByTrait("phone");
        assertTrue(c.compare(instance2,instance3) < 0);
        
        Comparator<Contact> c3 = instance3.getComparatorByTrait("email");
        assertTrue(c.compare(instance3,instance) > 0);
    }
    
}
