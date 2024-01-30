package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
