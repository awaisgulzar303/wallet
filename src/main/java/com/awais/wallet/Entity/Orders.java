package com.awais.wallet.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(name = "order_number", unique = true, nullable = false, length = 50)
    private String orderNumber;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Users users;
    @Column(name = "total_amount")
    private double total_amount;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;

    @PrePersist
    public void generateOrderNumber() {
        if (orderNumber == null) {
            this.orderNumber = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }


}
