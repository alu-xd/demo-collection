package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SportHandler implements InvocationHandler {
    private SportInterface sportInterface;

    public SportHandler(SportInterface sportInterface) {
        this.sportInterface = sportInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre action before sport");
        method.invoke(sportInterface, args);
        System.out.println("post action after sport");
        return null;
    }
}
