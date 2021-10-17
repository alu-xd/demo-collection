package proxy.jdkproxy;

public class Swimming implements SportInterface {

    @Override
    public void action() {
        System.out.println("swimming all the way");
    }

    public void drink(){
        System.out.println("drink");
    }
}
