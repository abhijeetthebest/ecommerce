package com.ecommerce.presentation.context.impl;

import com.ecommerce.presentation.context.View;

/**
 * Implementation of View interface.
 */
public class ViewImpl implements View {
    
    private String viewName;
    private String valueObjectName;
    private String valueObjectClass;
    private String valueObjectResultKey;
    
    /**
     * Construct a new view implementation.
     * 
     * @param viewName The view name
     * @param valueObjectName The value object name
     * @param valueObjectClass The value object class
     * @param valueObjectResultKey The value object result key
     */
    public ViewImpl(String viewName, String valueObjectName, String valueObjectClass, String valueObjectResultKey) {
        this.viewName = viewName;
        this.valueObjectName = valueObjectName;
        this.valueObjectClass = valueObjectClass;
        this.valueObjectResultKey = valueObjectResultKey;
    }
    
    /**
     * Get the view name.
     * 
     * @return The view name
     */
    public String getViewName() {
        return viewName;
    }
    
    /**
     * Get the value object name.
     * 
     * @return The value object name
     */
    public String getValueObjectName() {
        return valueObjectName;
    }
    
    /**
     * Get the value object class.
     * 
     * @return The value object class
     */
    public String getValueObjectClass() {
        return valueObjectClass;
    }
    
    /**
     * Get the value object result key.
     * 
     * @return The value object result key
     */
    public String getValueObjectResultKey() {
        return valueObjectResultKey;
    }
}
