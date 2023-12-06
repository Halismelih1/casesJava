package com.workshop.workshop.Services.dto.requests.Customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    @NotBlank(message = "firstname cannot be blank")
    private String firstName;
    @NotBlank(message = "Lastname cannot be blank")
    private String lastName;
    private String phone;
    private String email;
    @NotBlank(message = "adress cannot be blank")
    private String adress;
}
