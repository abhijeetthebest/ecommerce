package com.ecommerce.presentation.command.customer;

import com.ecommerce.business.bo.CustomerBO;
import com.ecommerce.presentation.command.AbstractCommand;
import com.ecommerce.presentation.context.View;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.util.Logger;
import com.ecommerce.view.ValueObject;
import com.ecommerce.view.customer.CustomerSummaryVO;
import com.ecommerce.view.customer.OrderHistoryVO;

/**
 * Command to prepare for adding an order history entry.
 */
public class OrderHistoryAddCommand extends AbstractCommand {
    
    /**
     * Perform the command execution.
     * 
     * @param context The window context
     * @return The result code (SUCCESS or FAILURE)
     * @throws FlowException If an error occurs during command execution
     */
    protected int performExecute(WindowContext context) throws FlowException {
        Logger.log(Logger.INFO, this.getClass().getName(), "performExecute", 
                "****** OrderHistoryAdd Command ******");
        
        int result = FAILURE;
        View v = context.getView();
        
        if (v != null) {
            ValueObject vo = (ValueObject) context.getValueObject(v.getValueObjectName());
            
            if (vo != null) {
                OrderHistoryVO ohVO = new OrderHistoryVO();
                
                if (vo instanceof CustomerSummaryVO) {
                    CustomerSummaryVO custVO = (CustomerSummaryVO) vo;
                    ohVO.setOrderEntryId(Long.parseLong(custVO.getCustomerId()));
                    
                    try {
                        CustomerBO cbo = CustomerBO.loadCustomer(Long.parseLong(custVO.getCustomerId()));
                        
                        if (cbo.getCustomerType() != null) {                        
                            ohVO.setCustomerType(cbo.getCustomerType().getLongDescription());
                        }
                        
                        ohVO.setCustomerNumber(cbo.getCustomerNumber());
                    } catch (Exception e) {
                        Logger.log(Logger.ERROR, this.getClass().getName(), "performExecute", 
                                "Error loading customer: " + e.getMessage());
                    }
                    
                    context.addValueObject(v.getValueObjectResultKey(), ohVO);
                    result = SUCCESS;
                }
            }
        }
        
        return result;
    }
}
