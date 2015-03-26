/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_4;

/**
 *
 * @author frank
 */
public class Project_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Variable x = new Variable("x");
        Variable n = new Variable("n");
        
        Function f = new Function("sum", new CompoundStatement(
                new Assignment(x, new Number(0)), 
                new Loop(new Comparison(Comparison.ComparisonOperator.GT, n, 
                        new Number(0)), new CompoundStatement(new Assignment(
                                x, new ArithmeticOperation(ArithmeticOperation
                                        .ArithmeticOperator.ADD, x, n)), 
                                new Assignment(n, new ArithmeticOperation(
                                        ArithmeticOperation.ArithmeticOperator.SUB, 
                                        n, new Number(1))))), new Return(x)), n);
        
        System.out.println("" + new FunctionCall(f, new Number(10)).value(new State()));
    }
    
}
