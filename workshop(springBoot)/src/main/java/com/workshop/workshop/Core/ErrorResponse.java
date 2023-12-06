package com.workshop.workshop.Core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
        private Date timestamp;
        private HttpStatus status;
        private String message;
}
