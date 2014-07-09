package nz.co.yellow.sandbox;

import org.springframework.stereotype.Component;

/**
 * Created by Y981821 on 9/07/2014.
 */
@Component
public class ExecuteScript {

    public static void main(String args[]) {
        ScriptWithTryAgain scriptWithTryAgain = new ScriptWithTryAgain();
        scriptWithTryAgain.ScriptPrint();
    }

}
