package project_4;

/**
 * Represents a group of statements in a single, compound statement.
 * @author Frank Hucek
 */
public class CompoundStatement extends Statements
{
  /**
   * Array of statements to be included in the compound statment.
   */
  protected Statements[] statements;
  
  /**
   * Sets each value of the input statements.
   * @param statements 
   */
  public CompoundStatement(Statements... statements)
  {
    this.statements = statements;
  }
  
  /**
   * Executes each statement in the compound statement.
   * @param s The state to which each statement is executed.
   */
  @Override
  public void execute(State s)
  {
    for(int i = 0; i < statements.length; i++)
      statements[i].execute(s);
  }
  
  /**
   * Retrieves the String representation of the Compound Statement.
   * @return Returns the String representation of the Compound statement.
   */
  @Override
  public String toString()
  {
    String s = "{";
    for(int i = 0; i < statements.length; i++)
      s = s + "\n" + statements[i].toStringTabbed(1);
    return s + "\n}";
  }
  
  /**
   * Retrieves the String of this Compound Statement with 'input' amount of tabs.
   * @param input The amount of tabs to include
   * @return The String that has been tabbed.
   */
  @Override
  public String toStringTabbed(int input)
  {
    String s = this.toString();
    for(int i = 0; i < input; i++)
    {
      s = "\t" + s;
    }
    return s;
  }
}