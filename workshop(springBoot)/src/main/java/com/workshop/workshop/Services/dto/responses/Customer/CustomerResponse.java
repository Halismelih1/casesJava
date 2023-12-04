package com.workshop.workshop.Services.dto.responses.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String adress;
}
