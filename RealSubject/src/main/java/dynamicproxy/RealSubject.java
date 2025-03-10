package dynamicproxy;

public class RealSubject implements Subject {
    public void request() {
        System.out.println("RealSubject is handling the request.");
    }
}