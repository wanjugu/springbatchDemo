package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loans,Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
