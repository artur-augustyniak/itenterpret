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
public class NonTerminalVariable implements Expression {

    private String name;

    NonTerminalVariable(String token) {
        this.name = token;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        if (null == variables.get(name)) {
            return 0;
        }
        return variables.get(name).interpret(variables);
    }
}
