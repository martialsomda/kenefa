package org.coders4africa.kenefa.jpa;

/**
 * This class contains convenient methods to ease the use of JPA through the whole application
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
public class JPAUtils {
    
   /**
     * Looks the Kenefa implementation class of any weaving entity
     * 
     * @param <T>
     * @param c
     * @return 
     */
   public  static <T> Class<? extends T> implementationClass(Class<? extends T> c) {

    Class<?> result = c;

    while (!result.getPackage().getName().startsWith("org.coders4africa.kenefa")) {
      result =  result.getSuperclass();

      if (result == null) {
        throw new IllegalArgumentException("Not an Kenefa entity");
      }
    }

    // This is safe if and only if T is in an Elimu package.
    return (Class<? extends T>) result;
  }
}
