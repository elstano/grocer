package com.sparkdan.grocer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Column
    private Date purchaseDate;

    @ManyToOne()
    @JoinColumn(name="shopId", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "receipt")
    private List<ReceiptImage> receiptImages;

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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<ReceiptImage> getReceiptImages() {
        return receiptImages;
    }

    public void setReceiptImages(List<ReceiptImage> receiptImages) {
        this.receiptImages = receiptImages;
    }
}
