package com.mahesh.SpringBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    @Autowired
    Bugs bugs;
    public void compile()
    {
        System.out.println("program is compiling....");
        bugs.foundBugs();
    }

}
