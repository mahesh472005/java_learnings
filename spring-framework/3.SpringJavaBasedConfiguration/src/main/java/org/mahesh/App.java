package org.mahesh;

import org.mahesh.Config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);


        Developer developer = applicationContext.getBean(Developer.class);
        System.out.println(developer.getAge());
        developer.code();
        System.out.println();

//        Laptop laptop = applicationContext.getBean("beast", Laptop.class);
//        laptop.compile();

    }
}
