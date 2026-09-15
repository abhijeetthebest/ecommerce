package com.ecommerce.presentation.command.customer;

import com.ecommerce.business.delegate.CustomerDelegate;
import com.ecommerce.business.delegate.OrderHistoryDelegate;
import com.ecommerce.business.exception.BusinessDelegateException;
import com.ecommerce.business.constants.OrderIdentifierType;
import com.ecommerce.presentation.command.AbstractCommand;
import com.ecommerce.presentation.context.View;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.util.Logger;
import com.ecommerce.view.customer.CustomerSummaryVO;
import com.ecommerce.view.customer.OrderHistoryVO;

/**
 * Command to save a new order history entry.
 */
public class OrderHistorySaveAddCommand extends AbstractCommand {
    
    /**
     * Perform the command execution.
     * 
     * @param context The window context
     * @return The result code (SUCCESS or FAILURE)
     * @throws FlowException If an error occurs during command execution
     */
    protected int performExecute(WindowContext context) throws FlowException {
        Logger.log(Logger.INFO, this.getClass().getName(), "performExecute", 
                "****** OrderHistorySaveAdd Command ******");
        
        int result = FAILURE;
        View v = context.getView();
        
        if (v != null) {
            OrderHistoryVO vo = (OrderHistoryVO) context.getValueObject(v.getValueObjectResultKey());
            
            if (vo != null) {
                try {
                    OrderHistoryDelegate.addOrderHistoryEntry(vo);
                    
                    if (!vo.isWebService()) {
                        int orderEntryTypeId = vo.getOrderEntryTypeId();
                        boolean maintain = vo.getMaintainScreen();
                        
                        if (orderEntryTypeId == OrderIdentifierType.CUSTOMER) {
                            if (maintain) {
                                // Return to maintain screen
                                context.addValueObject(v.getValueObjectResultKey(), 
                                        OrderHistoryDelegate.getCustomerOrderHistory(
                                                vo.getOrderEntryId(), false));
                            } else {
                                // Return to summary screen
                                context.addValueObject("customermaintenance.customerSummaryVO", 
                                        CustomerDelegate.getCustomerSummary(vo.getOrderEntryId()));
                            }
                            
                            result = SUCCESS;
                        }
                    }
                } catch (BusinessDelegateException e) {
                    throw new FlowException(e.getError(), e);
                }
            }
        }
        
        return result;
    }
}
