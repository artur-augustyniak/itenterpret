/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.implementation;

import interpreter.model.Expression;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author artur
 */
public class Parser implements Expression {

    private Expression syntaxTree;

    public Parser(String expression) {
        Stack<Expression> expressionStack = new Stack<Expression>();
        for (String token : expression.split(" ")) {
            if (token.equals("+")) {
                // in functional programming order of evaluatian may be very important but no in addition
                Expression subExpression = new TerminalPlus(expressionStack.pop(), expressionStack.pop());
                expressionStack.push(subExpression);
            } else if (token.equals("-")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new TerminalMinus(left, right);
                expressionStack.push(subExpression);
            } else {
                expressionStack.push(new NonTerminalVariable(token));
            }
        }
        syntaxTree = expressionStack.pop();
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        return syntaxTree.interpret(variables);
    }
}
