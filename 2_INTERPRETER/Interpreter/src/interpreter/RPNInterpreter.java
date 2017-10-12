/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.implementation.TerminalNumber;
import interpreter.implementation.Parser;
import interpreter.model.Expression;
import java.util.HashMap;
import java.util.Map;

/**
 * http://en.wikipedia.org/wiki/Interpreter_pattern
 *
 * @author
 */
public class RPNInterpreter {

    /**
     * @param args the command line arguments
     */
    //ant && java -jar dist/Interpreter.jar
    public static void main(String[] args) {
        String expression = "w x z - +";
        Parser sentence = new Parser(expression);
        Map<String, Expression> variables = new HashMap<String, Expression>();
        variables.put("w", new TerminalNumber(5));
        variables.put("x", new TerminalNumber(10));
        variables.put("z", new TerminalNumber(42));
        int result = sentence.interpret(variables);
        System.out.println(result);
    }
}
