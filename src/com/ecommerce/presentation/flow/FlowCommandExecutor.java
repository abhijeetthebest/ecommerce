package com.ecommerce.presentation.flow;

import com.ecommerce.presentation.context.ExternalContext;

/**
 * Interface for flow command executors.
 */
public interface FlowCommandExecutor {
    
    /**
     * Execute a flow action.
     * 
     * @param locator The flow locator
     * @param context The external context
     * @return A flow instruction
     * @throws FlowException If an error occurs during execution
     */
    FlowInstruction execute(FlowLocator locator, ExternalContext context) throws FlowException;
}
