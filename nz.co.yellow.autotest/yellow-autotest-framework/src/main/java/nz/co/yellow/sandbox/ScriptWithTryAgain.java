package nz.co.yellow.sandbox;

import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Y981821 on 9/07/2014.
 */
//@ContextConfiguration(classes = {YellowAutoTestContext.class})
@Component
public class ScriptWithTryAgain {

    @TryAgain
    public void ScriptPrint() {
        System.out.println("Script print ....");
    }
}
