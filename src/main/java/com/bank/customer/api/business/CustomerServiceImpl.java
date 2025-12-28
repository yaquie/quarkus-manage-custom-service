package com.bank.customer.api.business;

import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.domain.dto.CustomerRequest;
import com.bank.customer.api.domain.dto.CustomerResponse;
import com.bank.customer.api.respository.CustomerRepository;
import com.bank.customer.api.util.BusinessException;
import com.bank.customer.api.util.ManageExeption;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class CustomerServiceImpl implements  CustomerService{

    @Inject
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("getAllCustomers: " + customerRepository.findAll().stream().count());
       return customerRepository.findAll().stream().toList();
    }

    @Transactional
    public CustomerResponse create(CustomerRequest request) throws Exception {
        if (customerRepository.existsByDocumentNumber(request.getDocumentNumber())) {
            System.out.println("Document already exists");
            throw new BusinessException(ManageExeption.SE00001);
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setDocumentNumber(request.getDocumentNumber());
        customer.setEmail(request.getEmail());
        customer.setStatus("ACTIVE");

        customerRepository.persist(customer);
        System.out.println("Customer created" );

        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setDocumentNumber(customer.getDocumentNumber());
        response.setEmail(customer.getEmail());

        return response;
    }

    @Override
    public CustomerResponse findCustomersById(Long id) {
        Customer custo = customerRepository.findById(id);

        if (custo == null) {
            throw new BusinessException(ManageExeption.SE00002);
        }

        CustomerResponse response = new CustomerResponse();
        response.setId(custo.getId());
        response.setName(custo.getName());
        response.setDocumentNumber(custo.getDocumentNumber());
        response.setEmail(custo.getEmail());
        response.setStatus("ACTIVE");
        return response;
    }


}
