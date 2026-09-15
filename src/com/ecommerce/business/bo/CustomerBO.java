package com.ecommerce.business.bo;

import com.ecommerce.business.constants.CustomerType;
import com.ecommerce.presentation.util.Logger;

/**
 * Business object for customer.
 */
public class CustomerBO {
    
    private long customerId;
    private String customerNumber;
    private String customerName;
    private CustomerType customerType;
    
    /**
     * Load a customer.
     * 
     * @param customerId The customer ID
     * @return The customer business object
     * @throws Exception If an error occurs
     */
    public static CustomerBO loadCustomer(long customerId) throws Exception {
        try {
            Logger.log(Logger.INFO, CustomerBO.class.getName(), "loadCustomer", 
                    "Loading customer for ID: " + customerId);
            
            // For simplicity, create a mock customer
            CustomerBO bo = new CustomerBO();
            bo.setCustomerId(customerId);
            bo.setCustomerNumber("CUST" + customerId);
            bo.setCustomerName("John Doe");
            bo.setCustomerType(CustomerType.get(CustomerType.ECOM_TYPE_B2C));
            
            return bo;
        } catch (Exception e) {
            Logger.log(Logger.ERROR, CustomerBO.class.getName(), "loadCustomer", 
                    "Error loading customer: " + e.getMessage());
            throw new Exception("Error loading customer: " + e.getMessage(), e);
        }
    }
    
    /**
     * Get the customer ID.
     * 
     * @return The customer ID
     */
    public long getCustomerId() {
        return customerId;
    }
    
    /**
     * Set the customer ID.
     * 
     * @param customerId The customer ID
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    
    /**
     * Get the customer number.
     * 
     * @return The customer number
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    
    /**
     * Set the customer number.
     * 
     * @param customerNumber The customer number
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    /**
     * Get the customer name.
     * 
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }
    
    /**
     * Set the customer name.
     * 
     * @param customerName The customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    /**
     * Get the customer type.
     * 
     * @return The customer type
     */
    public CustomerType getCustomerType() {
        return customerType;
    }
    
    /**
     * Set the customer type.
     * 
     * @param customerType The customer type
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
