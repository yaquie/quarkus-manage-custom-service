package com.bank.customer.api.controller;

import com.bank.customer.api.business.CustomerService;
import com.bank.customer.api.domain.Customer;
import com.bank.customer.api.domain.dto.CustomerRequest;
import com.bank.customer.api.domain.dto.CustomerResponse;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    @Inject
    CustomerService customerService;

    @POST
    @Path("/save")
    public CustomerResponse create(@Valid CustomerRequest request) throws Exception {
    return customerService.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponse getCustomersById(@PathParam("id") Long id) {
        return customerService.findCustomersById(id);
    }
}
