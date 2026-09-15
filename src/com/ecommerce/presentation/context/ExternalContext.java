package com.ecommerce.presentation.context;

import java.util.Map;

/**
 * Interface for external context.
 */
public interface ExternalContext {
    
    /**
     * Get a request parameter.
     * 
     * @param name The parameter name
     * @return The parameter value
     */
    String getParameter(String name);
    
    /**
     * Get all request parameters.
     * 
     * @return A map of parameter names to values
     */
    Map<String, String[]> getParameterMap();
    
    /**
     * Get a request attribute.
     * 
     * @param name The attribute name
     * @return The attribute value
     */
    Object getAttribute(String name);
    
    /**
     * Set a request attribute.
     * 
     * @param name The attribute name
     * @param value The attribute value
     */
    void setAttribute(String name, Object value);
    
    /**
     * Get a session attribute.
     * 
     * @param name The attribute name
     * @return The attribute value
     */
    Object getSessionAttribute(String name);
    
    /**
     * Set a session attribute.
     * 
     * @param name The attribute name
     * @param value The attribute value
     */
    void setSessionAttribute(String name, Object value);
    
    /**
     * Get the context path.
     * 
     * @return The context path
     */
    String getContextPath();
}
