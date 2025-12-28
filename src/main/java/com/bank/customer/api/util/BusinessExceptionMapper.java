package com.bank.customer.api.util;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        ErrorResponse error = new ErrorResponse(
                e.getCode(),
                e.getMessage()
        );

        return Response
                .status(Response.Status.CONFLICT) // 409
                .entity(error)
                .build();
    }
}
