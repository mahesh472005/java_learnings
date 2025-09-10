package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "developer")
    private List<Laptop> laptop;

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
