package org.mahesh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Developer developer = applicationContext.getBean(Developer.class);
        developer.code();
        System.out.println();

    }
}
