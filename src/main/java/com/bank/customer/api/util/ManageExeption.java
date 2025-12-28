package com.bank.customer.api.util;

public enum ManageExeption {
    SE00001("SE00001", "Document Number already exists"),
    SE00002("SE00002", "Customer does not exits");

    private String code;
    private String message;

    ManageExeption(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
