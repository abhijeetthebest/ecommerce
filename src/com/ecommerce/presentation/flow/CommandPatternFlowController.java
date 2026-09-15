package com.ecommerce.presentation.flow;

import java.util.Map;
import com.ecommerce.presentation.context.ExternalContext;
import com.ecommerce.presentation.util.Logger;

/**
 * Implementation of FlowController that uses the Command Pattern.
 * Maps flow IDs to command executors that handle specific flows.
 */
public class CommandPatternFlowController implements FlowController {
    
    /** Map of flow IDs to command executors */
    protected Map<String, FlowCommandExecutor> executorMap;
    
    /**
     * Execute a flow action by delegating to the appropriate command executor.
     * 
     * @param locator The flow locator containing flow ID and action
     * @param context The external context containing request parameters
     * @return A flow instruction indicating the next view
     * @throws FlowException If an error occurs during flow execution
     */
    public FlowInstruction execute(FlowLocator locator, ExternalContext context) throws FlowException {
        try {
            Logger.log(Logger.DEBUG, this.getClass().getName(), "execute", 
                    "Executing flow: " + locator.getFlowId() + ", action: " + locator.getFlowAction());
            
            FlowCommandExecutor executor = this.executorMap.get(locator.getFlowId());
            if (executor == null) {
                throw new FlowException("No executor found for flow: " + locator.getFlowId());
            }
            
            return executor.execute(locator, context);
        } catch (FlowException fe) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "execute", 
                    "Flow exception: " + fe.getMessage());
            throw fe;
        } catch (Exception e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "execute", 
                    "Unexpected exception: " + e.getMessage());
            throw new FlowException(e.getMessage(), e);
        }
    }
    
    /**
     * Set the executor map.
     * 
     * @param executorMap Map of flow IDs to command executors
     */
    public void setExecutorMap(Map<String, FlowCommandExecutor> executorMap) {
        this.executorMap = executorMap;
    }
}
