package project_4;

/**
 * Class to set the name of a variable and lookup its value
 * @author Frank Hucek
 * Programming Project 4
 */
public class Variable implements Entity
{
  /**
   * Represents the name of the Variable.
   */
  private String name;
 
  /**
   * Sets the name of the Variable.
   * @param name Input name.
   */
  public Variable(String name)
  {
    this.name = name;
  }
  
  /**
   * Returns the String representation of this object's name.
   * @return The name as a String.
   */
  @Override
  public String toString()
  {
    return this.name;
  }
  
  /**
   * Looks up the value.
   * @param s State used to lookup the value of this variable.
   * @return Returns the value associated with this variable name.
   */
  @Override
  public int value(State s)
  {
    return s.lookup(this.toString());
  }
}