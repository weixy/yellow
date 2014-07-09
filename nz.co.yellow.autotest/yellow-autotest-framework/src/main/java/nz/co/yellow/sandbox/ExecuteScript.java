package nz.co.yellow.sandbox;

import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Y981821 on 9/07/2014.
 */
public class ExecuteScript {

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(YellowAutoTestContext.class);

        ScriptWithTryAgain scriptWithTryAgain = (ScriptWithTryAgain)context.getBean("scriptWithTryAgain");
        scriptWithTryAgain.ScriptPrint();
    }

}
