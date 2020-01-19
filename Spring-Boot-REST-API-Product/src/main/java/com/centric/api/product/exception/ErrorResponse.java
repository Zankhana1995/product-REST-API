package com.centric.api.product.exception;

import lombok.*;

import java.util.Date;

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
}
