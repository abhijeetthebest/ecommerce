package com.ecommerce.presentation.command;

import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.flow.FlowException;

/**
 * Interface for commands that perform business operations.
 */
public interface Command {
    
    /**
     * Execute the command.
     * 
     * @param context The window context
     * @return The result code
     * @throws FlowException If an error occurs during command execution
     */
    int execute(WindowContext context) throws FlowException;
}
