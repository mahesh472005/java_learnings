package org.mahesh.Config;

import org.mahesh.Computer;
import org.mahesh.Desktop;
import org.mahesh.Developer;
import org.mahesh.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "org.mahesh")
public class SpringConfig {


//    @Bean
//    @Qualifier(value = "desktop")
//    public Developer developer(Computer com)
//    {
//        Developer developer = new Developer();
//        developer.setAge(30);
//        developer.setComputer(com);
//        return developer;
//    }
//
//    @Bean
//    @Scope(scopeName = "prototype")
//    public Desktop desktop()
//    {
//        return  new Desktop();
//    }
//
//    @Bean(name = {"lap", "beast"})
//    @Primary
//    public Laptop laptop()
//    {
//        return new Laptop();
//    }
}
