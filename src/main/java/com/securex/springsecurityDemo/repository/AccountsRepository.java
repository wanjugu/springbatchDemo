package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(int customerId);
}
