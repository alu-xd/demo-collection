package proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {

        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        SportInterface sport = new Swimming();
        SportHandler sportHandler = new SportHandler(sport);

        SportInterface proxyInstance = (SportInterface) Proxy.newProxyInstance(SportInterface.class.getClassLoader(),
                sport.getClass().getInterfaces(), sportHandler);

        proxyInstance.action();
    }
}
