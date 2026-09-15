package com.ecommerce.presentation.command.customer;

import com.ecommerce.business.delegate.CustomerDelegate;
import com.ecommerce.business.exception.BusinessDelegateException;
import com.ecommerce.presentation.command.AbstractCommand;
import com.ecommerce.presentation.context.View;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.util.Logger;
import com.ecommerce.view.ValueObject;
import com.ecommerce.view.customer.CustomerSummaryVO;

/**
 * Command to display customer summary information.
 */
public class DisplayCustomerSummaryCommand extends AbstractCommand {
    
    /**
     * Perform the command execution.
     * 
     * @param context The window context
     * @return The result code (SUCCESS or FAILURE)
     * @throws FlowException If an error occurs during command execution
     */
    protected int performExecute(WindowContext context) throws FlowException {
        Logger.log(Logger.INFO, this.getClass().getName(), "performExecute", 
                "****** DisplayCustomerSummary Command ******");
        
        int result = FAILURE;
        View v = context.getView();
        
        if (v != null) {
            ValueObject vo = (ValueObject) context.getValueObject(v.getValueObjectName());
            
            try {
                if (vo != null) {
                    if (vo instanceof CustomerSummaryVO) {
                        CustomerSummaryVO custSumVO = (CustomerSummaryVO) vo;
                        
                        // Get customer summary data
                        CustomerSummaryVO newVO = CustomerDelegate.getCustomerSummary(
                                Long.parseLong(custSumVO.getCustomerId()));
                        
                        context.addValueObject(v.getValueObjectResultKey(), newVO);
                        result = SUCCESS;
                    }
                }
            } catch (BusinessDelegateException e) {
                throw new FlowException(e.getError(), e);
            }
        }
        
        return result;
    }
}
