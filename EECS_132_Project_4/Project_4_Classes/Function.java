package project_4;

/**
 * Represents a Function to be called.
 * @author Frank Hucek
 */
public class Function
{
  /**
   * The function's name.
   */
  protected String functionName;
  
  /**
   * The Statement comprising the function body.
   */
  protected Statements functionBody;
  
  /**
   * Array of variables representing the function parameters.
   */
  protected Variable[] functionParams;
  
  /**
   * Sets all field values.
   * @param functionName
   * @param functionBody
   * @param functionParams 
   */
  public Function(String functionName, Statements functionBody, Variable... functionParams)
  {
    this.functionName = functionName;
    this.functionBody = functionBody;
    this.functionParams = functionParams;
  }
  
  /**
   * Returns the String representation of the function
   * @return 
   */
  public String toString()
  {
    String s = "function " + this.functionName + " (";
    int i = 0;
    while(this.functionParams.length > 1 && i < functionParams.length - 2) 
    {
      s = s + this.functionParams[i].toString() + ", ";
    }
    s = s + this.functionParams[functionParams.length - 1] + ")\n";
    s = s + functionBody.toStringTabbed(1);
    return s;
  }
  
  /**
   * Retrieves the function parameters.
   * @return the Variable array of function parameters.
   */
  public Variable[] getVariables()
  {
    return this.functionParams;
  }
  
  /**
   * Retrieves the function's name.
   * @return The string Representation of the function's name.
   */
  public String getFunctionName()
  {
    return this.functionName;
  }   
  
  /**
   * Retrienves the Body of the function.
   * @return The Statement containing the function body.
   */
  public Statements getFunctionBody()
  {
    return this.functionBody;
  }
}