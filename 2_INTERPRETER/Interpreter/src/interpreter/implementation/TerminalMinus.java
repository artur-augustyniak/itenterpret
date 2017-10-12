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
public class TerminalMinus implements Expression {

    Expression left;
    Expression right;

    public TerminalMinus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        return left.interpret(variables) - right.interpret(variables);
    }
}