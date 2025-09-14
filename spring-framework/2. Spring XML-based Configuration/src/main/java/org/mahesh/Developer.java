package org.mahesh;

import java.beans.ConstructorProperties;

public class Developer {

    private int age;
    private Computer laptop;

    public Computer getLaptop() {
        return laptop;
    }

    public void setLaptop(Computer laptop) {
        this.laptop = laptop;
    }

    public void code()
    {
        System.out.println("coding");
        laptop.compile();
    }
}
