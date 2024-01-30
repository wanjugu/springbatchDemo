package com.securex.springsecurityDemo.repository;

import com.securex.springsecurityDemo.entities.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsTransactionsRepository extends JpaRepository<AccountTransactions,Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
