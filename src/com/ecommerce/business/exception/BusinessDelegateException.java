package com.ecommerce.business.exception;

/**
 * Exception thrown by business delegates.
 */
public class BusinessDelegateException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    private String error;
    
    /**
     * Construct a new business delegate exception.
     * 
     * @param error The error message
     */
    public BusinessDelegateException(String error) {
        super(error);
        this.error = error;
    }
    
    /**
     * Construct a new business delegate exception.
     * 
     * @param error The error message
     * @param cause The cause
     */
    public BusinessDelegateException(String error, Throwable cause) {
        super(error, cause);
        this.error = error;
    }
    
    /**
     * Get the error message.
     * 
     * @return The error message
     */
    public String getError() {
        return error;
    }
}
