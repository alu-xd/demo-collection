package proxy.springaop;


import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello{
    @Override
    public void sayHello() {
        System.out.println("hello java");
    }
}
