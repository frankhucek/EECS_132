package project_4;

/**
 * Interface with method stubs to lookup a boolean value 
 * and the name of an object.
 * @author Frank Hucek
 * Programming Project 4
 */
public interface BooleanValue
{
  /**
   * The boolean result of calculation using the specified State.
   * @param s The state used to lookup the value.
   * @return returns true or false based on condition calculation.
   */
  public boolean value(State s);
  
  /**
   * The String representation of this operation.
   * @return Returns this operation in String form.
   */
  public String toString();
}