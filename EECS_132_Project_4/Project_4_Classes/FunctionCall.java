package project_4;

/**
 * Evaluates a Function.
 * @author Frank Hucek
 */
public class FunctionCall implements Entity
{
  /**
   * The function to be evaluated.
   */
  protected Function function;
  
  /**
   * An array of arguements for the function.
   */
  protected Entity[] arguments;
  
  /**
   * Sets the values of the fields.
   * @param function
   * @param arguments 
   */
  public FunctionCall(Function function, Entity... arguments)
  {
    this.function = function;
    this.arguments = arguments;
  }
  
  /**
   * Evaluates the value of the function.
   * @param s State to be manipulated.
   * @return Integer value returned after function evaluation.
   */
  @Override
  public int value(State s)
  {
    State newState = new State();
    Variable[] variables = function.getVariables();
    for(int i = 0; i < variables.length; i++)
      newState.update(variables[i].toString(), arguments[i].value(s));
    
    this.function.getFunctionBody().execute(newState); 
    return newState.lookup("return");
  }
  
  /**
   * Returns a String Representation of the FunctionCall.
   * @return The String representing the function call.
   */
  @Override
  public String toString()
  {
    String s = function.getFunctionName() + "(";
    int i = 0;
    while(this.arguments.length > 1 && i < this.arguments.length - 2) 
    {
      s = s + this.arguments[i].toString() + ", ";
    }
    s = s + this.arguments[arguments.length - 1] + ")";
    return s;
  }
}










