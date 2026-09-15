package com.ecommerce.presentation.context;

/**
 * Interface for window context.
 */
public interface WindowContext {
    
    /**
     * Get the view.
     * 
     * @return The view
     */
    View getView();
    
    /**
     * Set the view.
     * 
     * @param view The view
     */
    void setView(View view);
    
    /**
     * Get a value object.
     * 
     * @param name The value object name
     * @return The value object
     */
    Object getValueObject(String name);
    
    /**
     * Add a value object.
     * 
     * @param name The value object name
     * @param valueObject The value object
     */
    void addValueObject(String name, Object valueObject);
    
    /**
     * Check if the user has permission for a resource.
     * 
     * @param resource The resource
     * @param accessType The access type
     * @return True if the user has permission, false otherwise
     */
    boolean hasPermission(Object resource, int accessType);
}
