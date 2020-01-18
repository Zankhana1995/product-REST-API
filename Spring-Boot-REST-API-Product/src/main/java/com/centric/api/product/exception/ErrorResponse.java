package com.centric.api.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * The Error Response Model class
 *
 * @author Zankhana Patel
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String details;
}
