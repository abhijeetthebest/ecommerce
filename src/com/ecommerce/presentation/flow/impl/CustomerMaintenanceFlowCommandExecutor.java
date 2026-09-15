package com.ecommerce.presentation.flow.impl;

import java.util.HashMap;
import java.util.Map;
import com.ecommerce.presentation.command.Command;
import com.ecommerce.presentation.command.customer.DisplayCustomerSummaryCommand;
import com.ecommerce.presentation.command.customer.OrderHistoryAddCommand;
import com.ecommerce.presentation.command.customer.OrderHistorySaveAddCommand;
import com.ecommerce.presentation.context.ExternalContext;
import com.ecommerce.presentation.context.View;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.context.impl.ViewImpl;
import com.ecommerce.presentation.context.impl.WindowContextImpl;
import com.ecommerce.presentation.flow.FlowCommandExecutor;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.flow.FlowInstruction;
import com.ecommerce.presentation.flow.FlowLocator;
import com.ecommerce.presentation.util.Logger;
import com.ecommerce.view.customer.CustomerSummaryVO;
import com.ecommerce.view.customer.OrderHistoryVO;
import com.ecommerce.view.customer.ViewOrderHistoryVO;

/**
 * Flow command executor for customer maintenance.
 */
public class CustomerMaintenanceFlowCommandExecutor implements FlowCommandExecutor {
    
    private Map<String, ActionConfig> actionConfigMap;
    
    /**
     * Construct a new customer maintenance flow command executor.
     */
    public CustomerMaintenanceFlowCommandExecutor() {
        actionConfigMap = new HashMap<>();
        
        // Configure actions
        actionConfigMap.put("DisplayCustomerSummary", new ActionConfig(
                new DisplayCustomerSummaryCommand(),
                "/customer/maintainCustomerInformation.jsp",
                "/error.jsp",
                "customerSummaryVO",
                "com.ecommerce.view.customer.CustomerSummaryVO",
                "customermaintenance.customerSummaryVO"));
        
        actionConfigMap.put("OrderHistoryAdd", new ActionConfig(
                new OrderHistoryAddCommand(),
                "/customer/addOrderHistory.jsp",
                "/error.jsp",
                "customerSummaryVO",
                "com.ecommerce.view.customer.CustomerSummaryVO",
                "orderHistoryVO"));
        
        actionConfigMap.put("OrderHistoryAddSave", new ActionConfig(
                new OrderHistorySaveAddCommand(),
                "/customer/maintainCustomerInformation.jsp",
                "/error.jsp",
                "orderHistoryVO",
                "com.ecommerce.view.customer.OrderHistoryVO",
                "orderHistoryVO"));
        
        // Add more action configurations as needed
    }
    
    /**
     * Execute a flow action.
     * 
     * @param locator The flow locator
     * @param context The external context
     * @return A flow instruction
     * @throws FlowException If an error occurs during execution
     */
    public FlowInstruction execute(FlowLocator locator, ExternalContext context) throws FlowException {
        try {
            String flowAction = locator.getFlowAction();
            
            Logger.log(Logger.INFO, this.getClass().getName(), "execute", 
                    "Executing action: " + flowAction);
            
            // Get action configuration
            ActionConfig config = actionConfigMap.get(flowAction);
            
            if (config == null) {
                throw new FlowException("Unknown action: " + flowAction);
            }
            
            // Create view
            View view = new ViewImpl("WEB", config.getValueObjectName(), 
                    config.getValueObjectClass(), config.getValueObjectResultKey());
            
            // Create window context
            WindowContext windowContext = new WindowContextImpl();
            windowContext.setView(view);
            
            // Create value object
            Object valueObject = null;
            
            if (config.getValueObjectClass().equals("com.ecommerce.view.customer.CustomerSummaryVO")) {
                valueObject = new CustomerSummaryVO();
                ((CustomerSummaryVO) valueObject).setCustomerId(context.getParameter("customerId"));
            } else if (config.getValueObjectClass().equals("com.ecommerce.view.customer.OrderHistoryVO")) {
                valueObject = new OrderHistoryVO();
                // Set properties from request parameters
            } else if (config.getValueObjectClass().equals("com.ecommerce.view.customer.ViewOrderHistoryVO")) {
                valueObject = new ViewOrderHistoryVO();
                // Set properties from request parameters
            }
            
            // Add value object to window context
            windowContext.addValueObject(view.getValueObjectName(), valueObject);
            
            // Execute command
            int result = config.getCommand().execute(windowContext);
            
            // Handle result
            if (result == 0) { // SUCCESS
                return new FlowInstruction(config.getSuccessView(), false);
            } else { // FAILURE
                return new FlowInstruction(config.getFailureView(), false);
            }
        } catch (Exception e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "execute", 
                    "Error executing action: " + e.getMessage());
            throw new FlowException("Error executing action: " + e.getMessage(), e);
        }
    }
    
    /**
     * Configuration for an action.
     */
    private static class ActionConfig {
        
        private Command command;
        private String successView;
        private String failureView;
        private String valueObjectName;
        private String valueObjectClass;
        private String valueObjectResultKey;
        
        /**
         * Construct a new action configuration.
         * 
         * @param command The command
         * @param successView The success view
         * @param failureView The failure view
         * @param valueObjectName The value object name
         * @param valueObjectClass The value object class
         * @param valueObjectResultKey The value object result key
         */
        public ActionConfig(Command command, String successView, String failureView, 
                String valueObjectName, String valueObjectClass, String valueObjectResultKey) {
            this.command = command;
            this.successView = successView;
            this.failureView = failureView;
            this.valueObjectName = valueObjectName;
            this.valueObjectClass = valueObjectClass;
            this.valueObjectResultKey = valueObjectResultKey;
        }
        
        /**
         * Get the command.
         * 
         * @return The command
         */
        public Command getCommand() {
            return command;
        }
        
        /**
         * Get the success view.
         * 
         * @return The success view
         */
        public String getSuccessView() {
            return successView;
        }
        
        /**
         * Get the failure view.
         * 
         * @return The failure view
         */
        public String getFailureView() {
            return failureView;
        }
        
        /**
         * Get the value object name.
         * 
         * @return The value object name
         */
        public String getValueObjectName() {
            return valueObjectName;
        }
        
        /**
         * Get the value object class.
         * 
         * @return The value object class
         */
        public String getValueObjectClass() {
            return valueObjectClass;
        }
        
        /**
         * Get the value object result key.
         * 
         * @return The value object result key
         */
        public String getValueObjectResultKey() {
            return valueObjectResultKey;
        }
    }
}
