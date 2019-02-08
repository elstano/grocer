package com.sparkdan.grocer;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products_in_shop")
public class ProductInShop {
    @EmbeddedId
    private ProductInShopId id;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("id")
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("id")
    private Shop shop;
    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("id")
    private Department department;

    public ProductInShop(Product product, Shop shop, Department department) {
        this.product = product;
        this.shop = shop;
        this.department = department;
        this.id = new ProductInShopId(shop.getId(), product.getId(), department.getId());
    }

    public ProductInShop() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInShop that = (ProductInShop) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(shop, that.shop) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, shop, department);
    }
}
