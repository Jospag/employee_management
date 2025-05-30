package com.semicolon.springbootbackend.exception;

import java.util.Date;

/**
 * Standard error response structure for API errors.
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructs a new error details object.
     *
     * @param timestamp the time when the error occurred
     * @param message the error message
     * @param details additional details about the error
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
