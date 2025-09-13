package org.mahesh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*Key Learnings :
        * Bean is an object which is created and maintained by the spring
          in the IOC Container.
        * When you set the values using Property tag in bean, the bean
          calls the setter method in Developer by default, this feature
          is called setter injection
        * We have two types of scopes :
            1.singleton (default)
            2.prototype
        * When the Developer bean is defined as a singleton, the IOC Container
          creates only one instance of the Developer object at the start of the
          application. Each time you call getBean(), you get the same reference
          to that single object. In this scope, Developer object is created at
          the ApplicationContext line itself.
        * When the Developer bean is defined as a prototype, the IOC Container
          creates a new Developer object every time you call getBean(). Each call
          will give you a different instance, so the object is created only when
          requested. In this scope, Developer object is created only if you
          invoke/call the getBean() method
        * In the bean tag, if you refer to a primitive value we use `value` in the
          property tag, where as if you want to refer to an object we use the `ref`
          in the property tag, check the laptop reference in spring.xml, this is also
          a setter injection but with `ref`

       Constructor  Injection :
        *   When a class (e.g., Developer) has attributes like age (primitive) and
            laptop (object), we can assign values using constructor injection in
            Spring with <constructor-arg> inside the bean configuration.
        *   <constructor-arg> have 4 attributes :
            1. value :-
                * Used to pass primitive values.
                * Values must be passed in sequence, as per constructor order.
            2. ref :-
                * Used to pass object references.
                * Objects must also be passed in sequence.
            3. name :-
                * Used to pass values or objects by constructor parameter name.
                * Order does not matter.
                * Requires @ConstructorProperties({"age", "laptop"}) annotation before
                  the constructor in the Developer class.
            4. index  :-
                * Used to pass values or objects by their position in the constructor.
            5. type  :-
                * Used to pass values or objects by their type in the constructor.
                * Order does not matter.
           */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Developer developer1 = applicationContext.getBean(Developer.class);
        System.out.println(developer1.getAge());
        developer1.code();
        System.out.println();

        Developer developer2 = applicationContext.getBean(Developer.class);
        developer2.code();

    }
}
