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
public class TerminalNumber implements Expression {

    private int number;

    public TerminalNumber(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        return number;
    }
}
