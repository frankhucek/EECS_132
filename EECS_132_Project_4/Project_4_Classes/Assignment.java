package project_4;

/**
 * Class that assigns a variable to a value.
 * @author Frank Hucek
 * Programming Project 4
 */
public class Assignment extends Statements
{
  /**
   * Variable field to set the value of.
   */
  protected Variable variable;
  
  /**
   * Entity field to set the value of the variable. 
   */
  protected Entity entity;
  
  /**
   * Sets the values of the variable and its assignment value.
   * @param variable
   * @param entity 
   */
  public Assignment(Variable variable, Entity entity)
  {
    this.variable = variable;
    this.entity = entity;
  }
  
  /**
   * Executes the assignment operation into the state.
   * @param s State where Variable and its assigned value are stored together.
   */
  @Override
  public void execute(State s)
  {
    s.update(variable.toString(),entity.value(s));
  }
  
  /**
   * Retrieves the String representation of the Assignment.
   * @return The String of the Assignment.
   */
  @Override
  public String toString()
  {
    return variable.toString() + " := " + entity.toString() + ";";
  }
  
  /**
   * Retrieves the String representation of the Assignment with tabs.
   * @param input amount of tabs to include in String.
   * @return Returns the new String of the Assignement with input amount of tabs.
   */
  @Override
  public String toStringTabbed(int input)
  {
    String s = "";
    for(int i = 0; i < input; i++)
        s = s + "\t";
    s = s + this.toString();
    return s;
  }
}