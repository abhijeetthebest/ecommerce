package com.ecommerce.presentation.flow;

/**
 * Exception thrown during flow execution.
 */
public class FlowException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs a new flow exception with the specified detail message.
     * 
     * @param message The detail message
     */
    public FlowException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new flow exception with the specified detail message and cause.
     * 
     * @param message The detail message
     * @param cause The cause
     */
    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
