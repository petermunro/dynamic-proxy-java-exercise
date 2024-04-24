package proxydemo;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();

        Calculator calcProxy = (Calculator) Proxy.newProxyInstance(
                calc.getClass().getClassLoader(),
                new Class[] { Calculator.class }, new CalculatorProxy(calc));

        // invoked directly
        int result1 = calc.add(5, 7);
        System.out.println(result1);

        // invoked via proxy
        int result2 = calcProxy.subtract(5, 7);
        System.out.println(result2);

    }
}
