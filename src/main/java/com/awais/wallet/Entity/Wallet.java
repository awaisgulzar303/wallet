package com.awais.wallet.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @Column(name = "balance")
    private float balance;

    @Column(name = "version")
    @Version
    private int version;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;


    @Column(name = "updated_at", updatable = true)
    @UpdateTimestamp
    private Date updated_at;


}
