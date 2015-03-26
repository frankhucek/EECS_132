package project_4;

/**
 * Performs a comparison between 2 operands.
 * @author Frank Hucek
 * Programming Project 4
 */
public class Comparison extends Operation<Entity> implements BooleanValue
{
  /**
   * Sets the values to perform the operation on.
   * @param operator
   * @param leftOperand
   * @param rightOperand 
   */
  public Comparison(Operator operator, Entity leftOperand, Entity rightOperand) 
  {
    super(operator, leftOperand, rightOperand);
  }

  /**
   * Enumerated type class with values to recognize calls to Less than,
   * Less than or equal to, Greater than, Greater than or equal to, 
   * equivalence, and non-equivalence.
   */
  public enum ComparisonOperator implements Operator
  {
    LT("<"),
    LTE("<="),
    GT(">"),
    GTE(">="),
    EQ("=="),
    NEQ("!=");
    
    private String operator;
    
    ComparisonOperator(String operator)
    {
      this.operator = operator;
    }
    
    public String getOperator()
    {
      return operator;
    }
  }
  
  /**
   * Retrieves the boolean value after the comparison.
   * @param s State to retrieve variable values.
   * @return Returns true/false based on comparison of left and right operands.
   */
  public boolean value(State s)
  {
    boolean result;
    
    switch((ComparisonOperator)operator)
    {
      case LT:
        result = leftOperand.value(s) < rightOperand.value(s);
        break;
      case LTE:
        result = leftOperand.value(s) <= rightOperand.value(s);
        break;
      case GT:
        result = leftOperand.value(s) > rightOperand.value(s);
        break;
      case GTE:
        result = leftOperand.value(s) >= rightOperand.value(s);
        break;
      case EQ:
        result = leftOperand.value(s) == rightOperand.value(s);
        break;
      case NEQ:
        result = leftOperand.value(s) != rightOperand.value(s);
        break;
      default:
        result = false;
        break;
    }
    return result;
  }
  
  /**
   * Retrieves String representation of comparison.
   * @return Returns the Comparison in the form of a String.
   */
  @Override
  public String toString()
  {
    String s;
    
    switch((ComparisonOperator)operator)
    {
      case LT:
        s = leftOperand.toString() + " < " + rightOperand.toString();
        break;
      case LTE:
        s = leftOperand.toString() + " <= " + rightOperand.toString();
        break;
      case GT:
        s = leftOperand.toString() + " > " + rightOperand.toString();
        break;
      case GTE:
        s = leftOperand.toString() + " >= " + rightOperand.toString();
        break;
      case EQ:
        s = leftOperand.toString() + " == " + rightOperand.toString();
        break;
      case NEQ:
        s = leftOperand.toString() + " != " + rightOperand.toString();
        break;
      default:
        s = "";
        break;
    }
    return s;
  }
}