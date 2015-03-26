package project_4;

/**
 * Abstract class containing details for each operation.
 * @author Frank Hucek
 * @param <T> Whatever type to be used.
 */
public abstract class Operation<T>  
{
  /**
   * The enum class operator to be called.
   */
  protected final Operator operator;
  
  /**
   * The left and right operations of each pending operation.
   */
  protected final T leftOperand, rightOperand;
  
  /**
   * Sets the field values.
   * @param operator
   * @param leftOperand
   * @param rightOperand 
   */
  public Operation(Operator operator, T leftOperand, T rightOperand) 
  {
    this.operator = operator;
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
  }
}
