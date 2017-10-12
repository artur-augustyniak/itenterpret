/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.implementation;

import interpreter.model.Expression;
import java.util.Map;

/**
 *
 * @author artur
 */
public class TerminalPlus  implements Expression{

    Expression left;
    Expression right;

    public TerminalPlus(Expression left, Expression right) {
        System.out.println(right);
        System.out.println(left);
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        return left.interpret(variables) + right.interpret(variables);
    }
    
}
