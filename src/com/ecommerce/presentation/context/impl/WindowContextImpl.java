package com.ecommerce.presentation.context.impl;

import java.util.HashMap;
import java.util.Map;
import com.ecommerce.presentation.context.View;
import com.ecommerce.presentation.context.WindowContext;

/**
 * Implementation of WindowContext interface.
 */
public class WindowContextImpl implements WindowContext {
    
    private View view;
    private Map<String, Object> valueObjects;
    
    /**
     * Construct a new window context implementation.
     */
    public WindowContextImpl() {
        this.valueObjects = new HashMap<>();
    }
    
    /**
     * Get the view.
     * 
     * @return The view
     */
    public View getView() {
        return view;
    }
    
    /**
     * Set the view.
     * 
     * @param view The view
     */
    public void setView(View view) {
        this.view = view;
    }
    
    /**
     * Get a value object.
     * 
     * @param name The value object name
     * @return The value object
     */
    public Object getValueObject(String name) {
        return valueObjects.get(name);
    }
    
    /**
     * Add a value object.
     * 
     * @param name The value object name
     * @param valueObject The value object
     */
    public void addValueObject(String name, Object valueObject) {
        valueObjects.put(name, valueObject);
    }
    
    /**
     * Check if the user has permission for a resource.
     * 
     * @param resource The resource
     * @param accessType The access type
     * @return True if the user has permission, false otherwise
     */
    public boolean hasPermission(Object resource, int accessType) {
        // For simplicity, always return true
        return true;
    }
}
