package com.workshop.workshop.Services.dto.requests.Customer;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String adress;
}
