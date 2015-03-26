package project_4;

/**
 * Interface containing methods to retreive values and String representations
 * @author Frank Hucek
 * Programming Project 4
 */

public interface Entity
{
  /**
   * Method stub returning an integer value.
   * @param s State to be manipulated
   * @return Returns an integer value after calculation.
   */
  public int value(State s);
  
  /**
   * Method stub returning a String representation of the object.
   * @return Returns the String associated with this object.
   */
  public String toString();
}
