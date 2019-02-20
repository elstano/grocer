package com.sparkdan.grocer;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class ReceiptImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="receipt_id", nullable = false)
    private Receipt receipt;

    @Column
    private Blob image;

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

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
