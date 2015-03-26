package project_4;

/**
 * Represents a Conditional Statement.
 * Checks truth of an operation and executes a statement if it is true,
 * and executes another statement if it is false.
 * @author Frank Hucek
 */
public class ConditionalStatement extends Statements
{
  /**
   * The operation to be checked for truth.
   */
  protected BooleanValue operation;
  
  /**
   * If the condition is true, do this operation.
   */
  protected Statements ifCondition;
  
  /**
   * If the condition is false, do this operation.
   */
  protected Statements elseCondition;
  
  /**
   * Sets the values of each of the fields.
   * @param operation
   * @param ifCondition
   * @param elseCondition 
   */
  public ConditionalStatement(BooleanValue operation, Statements ifCondition, Statements elseCondition)
  {
    this.operation = operation;
    this.ifCondition = ifCondition;
    this.elseCondition = elseCondition;
  }
  
  /**
   * Executes the Conditional Statement.
   * @param s The state to be acted upon.
   */
  @Override
  public void execute(State s)
  {
    if(operation.value(s))
      ifCondition.execute(s);
    else
      elseCondition.execute(s);
  }
  
  /**
   * Returns the String representation of the Conditional Statement.
   * @return The String of the Conditional Statement.
   */
  @Override
  public String toString()
  {
    return "if (" + operation.toString() + ")\n" + ifCondition.toStringTabbed(1) 
      + "\nelse\n" + elseCondition.toStringTabbed(1);
  }
  /**
   * Returns the tabbed String representation of the Conditional Statement.
   * @param input The amount of tabs to include.
   * @return The tabbed String of the Conditional Statement.
   */
  @Override
  public String toStringTabbed(int input)
  {
    String s = this.toString();
    for(int i = 0; i < input; i++)
      s = "\t" + s;
    return s;
  }
}










