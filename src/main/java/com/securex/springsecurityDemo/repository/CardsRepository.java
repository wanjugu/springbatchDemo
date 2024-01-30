package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Cards;
import com.securex.springsecurityDemo.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardsRepository extends JpaRepository<Cards, Loans> {
    List<Cards> findByCustomerId(int customerId);
}
