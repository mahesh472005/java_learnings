package org.mahesh;

public class Laptop implements Computer {

    @Override
    public void compile()
    {
        System.out.println("compiling in the Laptop");
    }
}
