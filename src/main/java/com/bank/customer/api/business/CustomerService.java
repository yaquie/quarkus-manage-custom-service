package com.bank.customer.api.business;

import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.domain.dto.CustomerRequest;
import com.bank.customer.api.domain.dto.CustomerResponse;
import com.bank.customer.api.util.CustomerStatus;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public CustomerResponse create(CustomerRequest request) throws Exception;
    public CustomerResponse findCustomersById(Long id);
}
