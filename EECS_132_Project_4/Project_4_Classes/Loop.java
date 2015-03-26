package project_4;


public class Loop extends Statements
{
  protected BooleanValue condition;
  protected Statements statement;
  
  public Loop(BooleanValue condition, Statements statement) // Operation may need to only represent BooleanOperation and Comparison
  {
    this.condition = condition;
    this.statement = statement;
  }
  
  @Override
  public void execute(State s)
  {
    while(condition.value(s))
      statement.execute(s);
  }
  
  @Override
  public String toString()
  {
    return "while (" + condition.toString() + ")\n" + statement.toStringTabbed(1);
  }
  
  @Override
  public String toStringTabbed(int input)
  {
    String s = "";
    String string;
    for(int i = 0; i < input; i++)
        s = s + "\t";
    string = s + "while (" + condition.toString() + ")" + "\n" + 
            statement.toStringTabbed(1);
    return s;
  }
}