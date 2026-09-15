package com.ecommerce.presentation.flow;

/**
 * Locator for flow ID and action.
 */
public class FlowLocator {
    
    private String flowId;
    private String flowAction;
    
    /**
     * Construct a new flow locator.
     * 
     * @param flowId The flow ID
     * @param flowAction The flow action
     */
    public FlowLocator(String flowId, String flowAction) {
        this.flowId = flowId;
        this.flowAction = flowAction;
    }
    
    /**
     * Get the flow ID.
     * 
     * @return The flow ID
     */
    public String getFlowId() {
        return flowId;
    }
    
    /**
     * Get the flow action.
     * 
     * @return The flow action
     */
    public String getFlowAction() {
        return flowAction;
    }
}
