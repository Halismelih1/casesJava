package com.workshop.workshop.Core.ErrorMessageDto;

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

        // Constructor with only message parameter
        public ErrorResponse(String message) {
                this.message = message;
        }
}
