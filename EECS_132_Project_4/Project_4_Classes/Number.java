package project_4;

/**
 * This class represents a Variable whose name is also its value.
 * @author Frank Hucek
 * Programming Project 4
 */
public class Number extends Variable
{
  /**
   * Value this number represents
   */  
  private int value;
  
  /**
   * Sets the value of this Number object.
   * Calls String representation of the value to satisfy super class constructor.
   * @param value Input value.
   */
  public Number(int value)
  {
    super(value + "");
    this.value = value;
  }
  
  /**
   * Returns the value associated with this object.
   * @param s Merely used to satisfy override of parent classes
   * @return Returns the value of this Number object.
   */
  @Override
  public int value(State s)
  {
    return this.value;
  }
  
  /**
   * Returns the String representation of this Number object
   * @return Returns the value of this Number object in the form of a String.
   */
  @Override
  public String toString()
  {
    return "" + this.value;
  }
}
