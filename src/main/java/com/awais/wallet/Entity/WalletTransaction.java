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
@Table(name = "wallet_transactions")
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;


    @Column(name = "type")
    private Type type;

    @Column(name = "amount")
    private float amount;

    @Column(name = "balance_before")
    private float balance_before;

    @Column(name = "balance_after")
    private float balance_after;

    @ManyToOne(optional = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = true)
    private Orders orders;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created_at;
}
