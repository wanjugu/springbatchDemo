package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByEmail(String email); //derived method name query



}
