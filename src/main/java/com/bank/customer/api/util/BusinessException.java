package com.bank.customer.api.util;

public class BusinessException  extends RuntimeException {
    private String code;

    public BusinessException(ManageExeption error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
