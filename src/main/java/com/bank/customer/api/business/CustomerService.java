package com.bank.customer.api.business;

import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.util.CustomerStatus;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
}
