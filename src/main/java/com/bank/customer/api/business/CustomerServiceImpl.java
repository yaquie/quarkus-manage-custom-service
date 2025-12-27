package com.bank.customer.api.business;

import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.util.CustomerStatus;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements  CustomerService{

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer c = new Customer();
        c.setId(1L);
        c.setName("Jakie Alarcon");
        c.setDocumentNumber("71659305");
        c.setEmail("jakie@gmail.com");
        c.setStatus(String.valueOf(CustomerStatus.ACTIVE));

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setName("Xiomara Romani");
        c2.setDocumentNumber("71659317");
        c2.setEmail("xiomi@gmail.com");
        c2.setStatus(String.valueOf(CustomerStatus.ACTIVE));

        //return List.of(c);
        customers.add(c);
        customers.add(c2);
        return customers;
    }
}
