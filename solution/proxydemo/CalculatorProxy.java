package proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class CalculatorProxy implements InvocationHandler {
    private Logger logger = Logger.getLogger(CalculatorProxy.class.getName());
    private final Calculator calculator;

    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("Invoked method: " + method.getName());
        logger.info("Args:           " + Arrays.toString(args));
        Object result = method.invoke(calculator, args);
        logger.info("Result:         " + result);
        return result;
    }
}
