package com.prattis.samplemoviedatabase.controller.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Data
public class ControllerErrorResponse {
    
    private int status;
    private String message;
    private String timestamp;
}
