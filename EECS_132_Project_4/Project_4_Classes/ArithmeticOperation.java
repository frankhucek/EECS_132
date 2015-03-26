package project_4;

/**
 * Performs an Arithmetic Operation on 2 operands.
 * An Arithmetic Operation can be performed on any object 
 * of type Entity (Variable, Number, etc.).
 * @author Frank Hucek
 * Programming Project 4
 */
public class ArithmeticOperation extends Operation<Entity> implements Entity
{
  /**
   * Sets the values to perform the Operation on
   * @param operator
   * @param leftOperand
   * @param rightOperand 
   */
  public ArithmeticOperation(Operator operator, Entity leftOperand, Entity rightOperand) 
  {
    super(operator, leftOperand, rightOperand);
  }

  /**
   * Enumerated type class with values to recognize calls to Add, Subtract,
   * Multiply, Divide, or find Remainder
   */
  public enum ArithmeticOperator implements Operator
  {
    ADD('+'),
    SUB('-'),
    MULT('*'),
    DIV('/'),
    REM('%');
    
    private char operator;
    
    ArithmeticOperator(char operator)
    {
      this.operator = operator;
    }
    
    public char getOperator()
    {
      return operator;
    }
  }
  
  /**
   * Retrieve the value of the operation
   * @param s The state to perform the operation on
   * @return The result of the operation
   */
  @Override 
  public int value(State s)
  {
    int number;
    
    switch((ArithmeticOperator)operator)
    {
      case ADD:
        number = leftOperand.value(s) + rightOperand.value(s);
        break;
      case SUB:
        number = leftOperand.value(s) - rightOperand.value(s);
        break;
      case MULT:
        number = leftOperand.value(s) * rightOperand.value(s);
        break;
      case DIV:
        number = leftOperand.value(s) / rightOperand.value(s);
        break;
      case REM:
        number = leftOperand.value(s) % rightOperand.value(s);
        break;
      default:
        number = 0;
        break;
    }
    return number;
  }
  
  /**
   * Retrieves the String representation of this Operation.
   * @return the String representation.
   */
  @Override
  public String toString()
  {
    String s;
    
    switch((ArithmeticOperator)operator)
    {
      case ADD:
        s = leftOperand.toString() + " + " + rightOperand.toString();
        break;
      case SUB:
        s = leftOperand.toString() + " - " + rightOperand.toString();
        break;
      case MULT:
        s = leftOperand.toString() + " * " + rightOperand.toString();
        break;
      case DIV:
        s = leftOperand.toString() + " / " + rightOperand.toString();
        break;
      case REM:
        s = leftOperand.toString() + " % " + rightOperand.toString();
        break;
      default:
        s = "";
        break;
    }
    return s;
  }
}