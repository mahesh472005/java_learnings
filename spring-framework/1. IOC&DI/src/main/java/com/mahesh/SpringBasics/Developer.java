package com.mahesh.SpringBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {

    @Autowired
    Laptop laptop;

    public void code()
    {
       laptop.compile();
    }
}
