# Creating a Dynamic Proxy for Logging

## Objective

In this exercise, you will create a dynamic proxy that logs method invocations of an interface. The dynamic proxy will intercept method calls to the interface and log the method name and arguments before invoking the actual method.

Steps:

1. Create an interface named `Calculator` with the following methods:

   - `int add(int a, int b)`
   - `int subtract(int a, int b)`
   - `int multiply(int a, int b)`
   - `double divide(int a, int b)`

2. Create a class named `CalculatorImpl` that implements the `Calculator` interface. Implement the methods with basic arithmetic operations.

3. In the `main` method of a class named `Main`, create an instance of `CalculatorImpl`. Call one of the `Calculator` methods to verify that it works.

### Adding a Dynamic Proxy

4. Create a dynamic proxy class named `CalculatorProxy` that implements the `InvocationHandler` interface. This class will intercept method invocations on the `Calculator` interface.

  - The `CalculatorProxy` needs to have a reference to a `Calculator` instance. You can initialise this in its constructor.

5. In the `invoke` method of `CalculatorProxy`, perform the following steps:

   - Log the name of the invoked method using `method.getName()`.
   - Log the arguments passed to the method using `Arrays.toString(args)`.
   - Invoke the actual method on the underlying `CalculatorImpl` instance using `method.invoke(...)`. (Use the `.invoke(instance, args)` form.)
   - Log the result returned by the method.
   - Return the result.

7. In `main()`, create a dynamic proxy instance of the `Calculator` interface using `Proxy.newProxyInstance(...)`, passing the `CalculatorImpl` instance and an instance of `CalculatorProxy` as the invocation handler.

    - This bit is tricky. It should look something like this:

      ```java
      Calculator calcProxy = (Calculator) Proxy.newProxyInstance(
            calc.getClass().getClassLoader(),
            new Class[]{Calculator.class}, new CalculatorProxy(calc));
      ```

8. Now (also in `main()`) add further calls to the methods of the `Calculator` interface, but on the dynamic proxy instance. Look at the looged output and verify that the dynamic proxy is being called.


