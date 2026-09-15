package com.ecommerce.business.delegate;

import com.ecommerce.business.exception.BusinessDelegateException;
import com.ecommerce.view.customer.CustomerSummaryVO;
import com.ecommerce.presentation.util.Logger;

/**
 * Delegate for customer operations.
 */
public class CustomerDelegate {
    
    /**
     * Get customer summary.
     * 
     * @param customerId The customer ID
     * @return The customer summary
     * @throws BusinessDelegateException If an error occurs
     */
    public static CustomerSummaryVO getCustomerSummary(long customerId) throws BusinessDelegateException {
        try {
            Logger.log(Logger.INFO, CustomerDelegate.class.getName(), "getCustomerSummary", 
                    "Getting customer summary for customer ID: " + customerId);
            
            // For simplicity, create a mock customer summary
            CustomerSummaryVO vo = new CustomerSummaryVO();
            vo.setCustomerId(String.valueOf(customerId));
            vo.setCustomerCode("CUST" + customerId);
            vo.setCustomerName("John Doe");
            vo.setCustomerBirthDate("01/01/1980");
            vo.setCustomerAge("43");
            vo.setCustomerJoinedDate("01/01/2020");
            vo.setPreferredLanguage("English");
            vo.setSpecialAssistanceIndicator(new String[] {"N"});
            vo.setTestCustomerIndicator("N");
            
            vo.setPrimaryAddress("123 Main St");
            vo.setPrimaryCity("Anytown");
            vo.setPrimaryState("CA");
            vo.setPrimaryZip("12345");
            
            vo.setShippingAddress("123 Main St");
            vo.setShippingCity("Anytown");
            vo.setShippingState("CA");
            vo.setShippingZip("12345");
            
            vo.setBillingAddress("123 Main St");
            vo.setBillingCity("Anytown");
            vo.setBillingState("CA");
            vo.setBillingZip("12345");
            
            vo.setDayPhone("555-123-4567");
            vo.setEveningPhone("555-123-4567");
            vo.setMobilePhone("555-987-6543");
            vo.setEmail("john.doe@example.com");
            
            vo.setCustomerType("Business to Consumer");
            vo.setLoyaltyLevel("Gold");
            vo.setMarketingOptIn("Y");
            
            vo.setRecommendationEngineURL("https://recommendations.example.com?customerId=" + customerId);
            vo.setProspect(false);
            
            return vo;
        } catch (Exception e) {
            Logger.log(Logger.ERROR, CustomerDelegate.class.getName(), "getCustomerSummary", 
                    "Error getting customer summary: " + e.getMessage());
            throw new BusinessDelegateException("Error getting customer summary: " + e.getMessage(), e);
        }
    }
}
