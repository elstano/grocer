package com.sparkdan.grocer;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="shopId", nullable = false)
    private Shop shop;

    @OneToOne()
    @JoinColumn(name="nextDepartment")
    private Department nextDepartmnent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Department getNextDepartmnent() {
        return nextDepartmnent;
    }

    public void setNextDepartmnent(Department nextDepartmnent) {
        this.nextDepartmnent = nextDepartmnent;
    }
}
