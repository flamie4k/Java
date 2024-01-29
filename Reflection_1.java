import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection_1 {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> targetClass = Class.forName("java.io.IOException");
        
        // Constructor array
        Constructor<?>[] constructors = targetClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor Name: " + constructor);
            System.out.println("Count of Constructor Parameters: " + constructor.getParameterCount());

            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor Parameter: " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        // Method Array
        Method[] methods = targetClass.getDeclaredMethods();
        System.out.println("Number of Methods: " + methods.length);

        for (Method method : methods) {
            System.out.println("Method Name: \t" + method);
            System.out.println("Method Return Type: \t" + method.getReturnType());
            System.out.println("Method Parameter Count: \t" + method.getParameterCount());
            System.out.println();
            
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method Parameter: " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        // Annotations
        Class<?>[] classes = targetClass.getDeclaredClasses();
        for (Class<?> class1 : classes) {
            System.out.println("Class: " + class1);
            System.out.println("Name of Class: " + class1.getName());
        }
        
        // Annotations
        Annotation[] annotations = targetClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation: " + annotation);
        }
    }
}
