package com.ecommerce.presentation.context;

/**
 * Interface for view.
 */
public interface View {
    
    /**
     * Get the view name.
     * 
     * @return The view name
     */
    String getViewName();
    
    /**
     * Get the value object name.
     * 
     * @return The value object name
     */
    String getValueObjectName();
    
    /**
     * Get the value object class.
     * 
     * @return The value object class
     */
    String getValueObjectClass();
    
    /**
     * Get the value object result key.
     * 
     * @return The value object result key
     */
    String getValueObjectResultKey();
}
