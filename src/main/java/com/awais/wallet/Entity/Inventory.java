package com.awais.wallet.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private Users user;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stock_quantity;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;


}
