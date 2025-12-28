package com.bank.customer.api.respository;

import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.util.CustomerStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public Optional<Customer> findByDocumentNumber(String documentNumber) {
        return find("documentNumber", documentNumber).firstResultOptional();
    }

    public List<Customer> findActiveCustomers() {
        return list("status", CustomerStatus.ACTIVE);
    }

    public boolean existsByDocumentNumber(String documentNumber) {
        return count("documentNumber", documentNumber) > 0;
    }

}
