package com.ecommerce.presentation.context.impl;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.ecommerce.presentation.context.ExternalContext;

/**
 * Implementation of ExternalContext interface.
 */
public class ExternalContextImpl implements ExternalContext {
    
    private HttpServletRequest request;
    
    /**
     * Construct a new external context implementation.
     * 
     * @param request The HTTP servlet request
     */
    public ExternalContextImpl(HttpServletRequest request) {
        this.request = request;
    }
    
    /**
     * Get a request parameter.
     * 
     * @param name The parameter name
     * @return The parameter value
     */
    public String getParameter(String name) {
        return request.getParameter(name);
    }
    
    /**
     * Get all request parameters.
     * 
     * @return A map of parameter names to values
     */
    @SuppressWarnings("unchecked")
    public Map<String, String[]> getParameterMap() {
        return request.getParameterMap();
    }
    
    /**
     * Get a request attribute.
     * 
     * @param name The attribute name
     * @return The attribute value
     */
    public Object getAttribute(String name) {
        return request.getAttribute(name);
    }
    
    /**
     * Set a request attribute.
     * 
     * @param name The attribute name
     * @param value The attribute value
     */
    public void setAttribute(String name, Object value) {
        request.setAttribute(name, value);
    }
    
    /**
     * Get a session attribute.
     * 
     * @param name The attribute name
     * @return The attribute value
     */
    public Object getSessionAttribute(String name) {
        HttpSession session = request.getSession(false);
        return session != null ? session.getAttribute(name) : null;
    }
    
    /**
     * Set a session attribute.
     * 
     * @param name The attribute name
     * @param value The attribute value
     */
    public void setSessionAttribute(String name, Object value) {
        HttpSession session = request.getSession(true);
        session.setAttribute(name, value);
    }
    
    /**
     * Get the context path.
     * 
     * @return The context path
     */
    public String getContextPath() {
        return request.getContextPath();
    }
}
