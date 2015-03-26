package project_4;

/**
 * Performs a boolean operation on 2 Comparisons.
 * @author Frank Hucek
 * Programming Project 4
 */
public class BooleanOperation extends Operation<Comparison> implements BooleanValue
{
  /**
   * Sets the value of the operator and left and right side comparisons.
   * @param operator
   * @param leftSide
   * @param rightSide 
   */
  public BooleanOperation(Operator operator, Comparison leftSide, Comparison rightSide)
  {
    super(operator, leftSide, rightSide);
  }
  
  /**
   * Enumerated type class with values to recognize calls to And or Or.
   */
  public enum BooleanOperator implements Operator
  {
    AND,
    OR;
  }
  
  /**
   * Retrieve the value of the operation as true/false.
   * @param s The state to perform the operation on.
   * @return The result of the operation whether it was true/false.
   */
  @Override
  public boolean value(State s)
  {
    boolean booleanResult;
    switch((BooleanOperator)operator)
    {
      case AND:
        booleanResult = leftOperand.value(s) && rightOperand.value(s);
        break;
      case OR:
        booleanResult = leftOperand.value(s) || rightOperand.value(s);
        break;
      default:
        booleanResult = false;
        break;
    }
    return booleanResult;
  }
  
  /**
   * Retrieves String representation of Boolean operation on 2 comparisons.
   * @return Returns the Boolean operation in the form of a String.
   */
  @Override
  public String toString()
  {
    String s;
    switch((BooleanOperator)operator)
    {
      case AND:
        s = leftOperand.toString() + " && " + rightOperand.toString();
        break;
      case OR:
        s = leftOperand.toString() + " || " + rightOperand.toString();
        break;
      default:
        s = "";
        break;
    }
    return s;   
  }
}