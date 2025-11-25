package com.awais.wallet.Repository;

import com.awais.wallet.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRespository extends JpaRepository<Users, UUID> {
}
