/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.model;

import java.util.Map;

/**
 *
 * @author artur
 */
public interface Expression {

    public int interpret(Map<String, Expression> variables);
}
