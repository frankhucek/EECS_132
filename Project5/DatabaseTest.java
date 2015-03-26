package project5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Database Class
 * @author Frank Hucek
 */
public class DatabaseTest
{

    /**
     * Initializes an empty database storing Contacts.
     */
    Database<Contact> database = new Database<Contact>();

    /**
     * Creates 2 contacts to use for tests.
     */
    Contact c = new Contact("Frank", "1234", "fjh32@case.edu");
    Contact c2 = new Contact("Mike", "4321", "mike@gmail.com");

    /**
     * Tests the add method within the Database Class.
     */
    @Test
    public void testAdd()
    {
        database.add(c);
        assertTrue(database.getNodeptr().getElement().equals(c));
        
        database.add(c2);
        assertTrue(database.getNodeptr().getElement().equals(c2));
    }

    /**
     * Tests the delete method within Database Class.
     */
    @Test
    public void testDelete()
    {
        database.add(c);
        database.add(c2);
        database.delete(c);
        assertTrue(database.getNodeptr().getElement().toString().equals("Mike")); 
        
        database.add(c);
        database.add(c2);
        database.delete(c2);
        assertTrue(database.getNodeptr().getElement().toString().equals("Frank"));
    }

    /**
     * Tests LookupInList method within Database.
     */
    @Test
    public void testLookupInList()
    {
        database.add(c);
        database.add(c2);
        Comparator<Contact> comparator = c.getComparatorByTrait("phone");
        ArrayList<String> alist = new ArrayList();
        alist.add(c.getName());
        
        assertTrue(database.lookupInList(c, comparator).toString().equals(alist.toString()));
    }

    /**
     * Tests the LookupInIndex method within Database.
     */
    @Test
    public void testLookupInIndex()
    {
        database.add(c);
        database.add(c2);
        
        ArrayList<Contact> alist = new ArrayList();
        alist.add(c);
        alist.add(c2);
        
        Comparator<Contact> comparator = c.getComparatorByTrait("phone");
        ArrayList<String> newList = new ArrayList();
        newList.add(c.getName());
        assertTrue(database.lookupInIndex(c, alist, comparator).toString().equals(newList.toString()));
    }

    /**
     * Tests the lookup method within Database.
     */
    @Test
    public void testLookup()
    {
        database.add(c);
        database.add(c2);
        database.add(c);
        database.add(c2);
        
        LinkedList<Contact> LList = database.lookup("name", c);
        assertTrue(LList.get(0).equals(c));
        assertTrue(LList.get(1).equals(c));
    }

    /**
     * Tests the lookup method within Database.
     */
    @Test
    public void testGetList()
    {
        database.add(c);
        database.add(c2);
        
        database.makeIndex("name");
        ArrayList<Contact> alist = database.getList("name");
        assertTrue(alist.get(0).equals(c));
        assertTrue(alist.get(1).equals(c2));
    }
    
}
