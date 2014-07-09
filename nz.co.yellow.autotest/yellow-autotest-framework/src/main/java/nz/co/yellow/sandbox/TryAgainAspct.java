package nz.co.yellow.sandbox;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Y981821 on 9/07/2014.
 */
@Component
@Aspect
public class TryAgainAspct {
    @Before("@annotation(TryAgain)")
    public void tryAsp() {
        System.out.println("Aspect print ...");
    }
}
