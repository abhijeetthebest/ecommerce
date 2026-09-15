package com.ecommerce.presentation.flow;

import com.ecommerce.presentation.context.ExternalContext;

/**
 * Interface for flow controllers that handle navigation and command execution.
 */
public interface FlowController {
    
    /**
     * Execute a flow action.
     * 
     * @param locator The flow locator containing flow ID and action
     * @param context The external context containing request parameters
     * @return A flow instruction indicating the next view
     * @throws FlowException If an error occurs during flow execution
     */
    FlowInstruction execute(FlowLocator locator, ExternalContext context) throws FlowException;
}
