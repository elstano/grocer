package com.sparkdan.grocer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductInShopId implements Serializable {
    @Column(name = "shop_id")
    private String shopId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "department_id")
    private String departmentId;

    public ProductInShopId(String shopId, String productId, String departmentId) {
        this.shopId = shopId;
        this.productId = productId;
        this.departmentId = departmentId;
    }

    public ProductInShopId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInShopId that = (ProductInShopId) o;
        return Objects.equals(shopId, that.shopId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, productId, departmentId);
    }
}
