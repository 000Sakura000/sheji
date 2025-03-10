public class Main {
    public static void main(String[] args) {
        // 静态代理
        staticproxy.RealSubject realSubject = new staticproxy.RealSubject();
        staticproxy.Proxy proxy = new staticproxy.Proxy(realSubject);
        proxy.request();

        // 动态代理
        dynamicproxy.Subject dynamicProxy = (dynamicproxy.Subject) java.lang.reflect.Proxy.newProxyInstance(
                dynamicproxy.Subject.class.getClassLoader(),
                new Class<?>[] { dynamicproxy.Subject.class },
                new dynamicproxy.DynamicProxyHandler(new dynamicproxy.RealSubject())
        );
        dynamicProxy.request();
    }
}