import java.lang.reflect.Field;

import acme.NetworkService;

public class Driver {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        NetworkService ns = new NetworkService();
        ns.connect();
        
        // Get private field name
        /*
        Class reflectionTargetClass = ns.getClass();

	    Field fields[] = reflectionTargetClass.getDeclaredFields();
    	System.out.println("\nFields:");
	    for (Field field : fields) {
	    	System.out.println(field.getName() + " is: "
	    			+ field.toGenericString());
	    }
	    */
        
        Field fieldX = ns.getClass().getDeclaredField("machineName");
        fieldX.setAccessible(true);
        fieldX.set(ns, "aws.com");

        ns.connect();
        
    }

}
