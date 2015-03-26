package project_4;

import java.util.Hashtable;

/**
 * @author Frank Hucek
 * Programming Project 4
 * 
 * This class contains and uses a Hashtable from the API 
 * in order to store variable names and their values.
 */
public final class State
{
  /**
   * The Hashtable in which data is stored.
   */
    
  Hashtable<String, Integer> list = new Hashtable<String, Integer>();
  
  /**
   * Updates the Hashtable with a name and its associated value.
   * @param name Represents the name of a variable.
   * @param value Represents the integer value of the variable.
   */
  
  public void update(String name, int value)
  {
    list.put(name, value);
  }
  
  /**
   * Looks through the Hashtable for a value associated with the name.
   * @param name String to search for associated value.
   * @return returns value associated with name. If no value is found, returns 0.
   */
  
  public int lookup(String name)
  { 
    return list.get(name) == null ? 0 : list.get(name);
  }
}
