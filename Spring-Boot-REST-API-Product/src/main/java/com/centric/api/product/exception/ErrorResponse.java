package com.centric.api.product.exception;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * The Error Response Model class
 *
 * @author Zankhana Patel
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String details;
    private List<String> errors;
}
