import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProductionCodeTest {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        ProductionCode testSubject = new ProductionCode();

        int inputValue1 = 3;
        int inputValue2 = 7;
        int expectedResult = inputValue1 + inputValue2;

        // You can also call methods:
	    // Needs to specify parameter types in case
	    //   method name is overloaded.
	    System.out.println();
		ProductionCode target = new ProductionCode();
		Class<? extends ProductionCode> reflectionTargetClass = target.getClass();
	    Class[] argTypes = new Class[] { int.class, int.class };
	    Method privateMethodOnClass = reflectionTargetClass.getDeclaredMethod("add",argTypes);
	    privateMethodOnClass.setAccessible(true);
	    // Pass parameters as an array of objects
	    Object[] parms = new Object[] {inputValue1,inputValue2};
	    Object returnValue = privateMethodOnClass.invoke(target, parms);      
        
        int actualResult = (int) returnValue;

        if (actualResult == expectedResult)
            System.out.println("ProductionCode test passed.");
        else
            System.out.println("ProductionCode test failed.");
    }
}