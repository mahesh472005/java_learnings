package org.mahesh;

import java.beans.ConstructorProperties;

public class Developer {

    private int age;
    private Laptop laptop;

    public Developer()
    {
        System.out.println("Object created");
    }

    @ConstructorProperties({"age", "laptop"})
    public Developer(int age, Laptop laptop)
    {
        this.age = age;
        this.laptop = laptop;
    }


    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter Injection happened");
        this.age = age;
    }

    public void code()
    {
        System.out.println("coding");
        laptop.compile();
    }
}
