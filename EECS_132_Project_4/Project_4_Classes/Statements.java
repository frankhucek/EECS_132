package project_4;

/**
 * Represents a Statement.
 * @author Frank Hucek
 */
public abstract class Statements
{
  /** 
   * Executes the statement.
   * @param s State to be referred to.
   */
  public abstract void execute(State s);
  
  /**
   * Returns the String representation of the Statement.
   * @return The String of the Statement.
   */
  public abstract String toString();
  
  /**
   * Returns the tabbed String of the Statement
   * @param input amound of tabs to include.
   * @return Returns the String of the statement with tabs.
   */
  public abstract String toStringTabbed(int input);
}