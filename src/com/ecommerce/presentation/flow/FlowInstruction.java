package com.ecommerce.presentation.flow;

/**
 * Instruction for flow navigation.
 */
public class FlowInstruction {
    
    private String viewName;
    private boolean isRedirect;
    
    /**
     * Construct a new flow instruction.
     * 
     * @param viewName The view name
     * @param isRedirect Whether this is a redirect
     */
    public FlowInstruction(String viewName, boolean isRedirect) {
        this.viewName = viewName;
        this.isRedirect = isRedirect;
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
     * Check if this is a redirect.
     * 
     * @return True if this is a redirect, false otherwise
     */
    public boolean isRedirect() {
        return isRedirect;
    }
}
