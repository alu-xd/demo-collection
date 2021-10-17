package proxy.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class TimeAspect {

    @Before("execution(* proxy.springaop.Hello.sayHello(..))")
    public void logTime() {
        System.out.println("time: " + LocalDateTime.now());
    }
}
