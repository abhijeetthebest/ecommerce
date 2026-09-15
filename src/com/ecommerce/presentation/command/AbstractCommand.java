package com.ecommerce.presentation.command;

import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.util.Logger;

/**
 * Abstract base class for commands.
 */
public abstract class AbstractCommand implements Command {
    
    /** Success result code */
    protected static final int SUCCESS = 0;
    
    /** Failure result code */
    protected static final int FAILURE = 1;
    
    /**
     * Execute the command.
     * 
     * @param context The window context
     * @return The result code (SUCCESS or FAILURE)
     * @throws FlowException If an error occurs during command execution
     */
    public final int execute(WindowContext context) throws FlowException {
        Logger.log(Logger.DEBUG, this.getClass().getName(), "execute", 
                "Executing command: " + this.getClass().getSimpleName());
        
        try {
            return performExecute(context);
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
     * Perform the command execution.
     * 
     * @param context The window context
     * @return The result code (SUCCESS or FAILURE)
     * @throws FlowException If an error occurs during command execution
     */
    protected abstract int performExecute(WindowContext context) throws FlowException;
}
