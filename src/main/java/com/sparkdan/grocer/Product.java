package com.sparkdan.grocer;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Column
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="product_to_category",
        joinColumns = @JoinColumn(name="product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"))
    private List<ProductCategory> categories;

    @Column
    private String unit;
    @Column
    private Double increment;

    public Product() {

    }

    public Product(String name, List<ProductCategory> categories, String unit, Double increment) {
        this.name = name;
        this.categories = categories;
        this.unit = unit;
        this.increment = increment;
    }

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

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getIncrement() {
        return increment;
    }

    public void setIncrement(Double increment) {
        this.increment = increment;
    }
}
