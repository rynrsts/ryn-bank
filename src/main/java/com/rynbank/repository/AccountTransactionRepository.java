package com.rynbank.repository;

import com.rynbank.model.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Long> {

    List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(int customerId);

}
