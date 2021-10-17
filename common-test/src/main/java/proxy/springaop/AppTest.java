package proxy.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Hello hello = (Hello) context.getBean("helloImpl");
        hello.sayHello();
    }
}
