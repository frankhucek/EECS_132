package project_4;

/**
 * Represents a Return statement. 
 * Assigns a value in a State to the "return" name.
 * @author Frank Hucek
 */
public class Return extends Assignment
{
  /**
   * Calls constructor of Assignment class, 
   * setting Variable name to "return" and value to entity.
   * @param entity Assignment value to return.
   */
  public Return(Entity entity)
  {
    super(new Variable("return"), entity);
  }
  
  /**
   * Returns the String representation of the Return statement.
   * @return The String of return.
   */
  @Override 
  public String toString()
  {
    return "return " + entity.toString() + ";\n";
  }
  
  /**
   * Returns the tabbed String representation of the Return statement.
   * @param input However many tabs to include.
   * @return The String of the return statement with tabs.
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