package com.workshop.workshop.Services.dto.brand.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String adress;
}
