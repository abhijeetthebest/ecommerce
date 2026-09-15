package com.ecommerce.business.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Constants for customer types.
 */
public class CustomerType {
    
    /** B2C customer type */
    public static final int ECOM_TYPE_B2C = 1;
    
    /** B2B customer type */
    public static final int ECOM_TYPE_B2B = 2;
    
    /** Reseller customer type */
    public static final int ECOM_TYPE_RESELLER = 3;
    
    /** Wholesale customer type */
    public static final int ECOM_TYPE_WHOLESALE = 4;
    
    private static Map<Integer, CustomerType> instances = new HashMap<>();
    
    private int id;
    private String shortDescription;
    private String longDescription;
    
    /**
     * Construct a new customer type.
     * 
     * @param id The ID
     * @param shortDescription The short description
     * @param longDescription The long description
     */
    private CustomerType(int id, String shortDescription, String longDescription) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }
    
    /**
     * Get a customer type by ID.
     * 
     * @param id The ID
     * @return The customer type
     */
    public static CustomerType get(int id) {
        if (instances.isEmpty()) {
            initialize();
        }
        
        return instances.get(id);
    }
    
    /**
     * Initialize the customer types.
     */
    private static void initialize() {
        instances.put(ECOM_TYPE_B2C, new CustomerType(ECOM_TYPE_B2C, "B2C", "Business to Consumer"));
        instances.put(ECOM_TYPE_B2B, new CustomerType(ECOM_TYPE_B2B, "B2B", "Business to Business"));
        instances.put(ECOM_TYPE_RESELLER, new CustomerType(ECOM_TYPE_RESELLER, "RESELLER", "Reseller"));
        instances.put(ECOM_TYPE_WHOLESALE, new CustomerType(ECOM_TYPE_WHOLESALE, "WHOLESALE", "Wholesale"));
    }
    
    /**
     * Get the ID.
     * 
     * @return The ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the short description.
     * 
     * @return The short description
     */
    public String getShortDescription() {
        return shortDescription;
    }
    
    /**
     * Get the long description.
     * 
     * @return The long description
     */
    public String getLongDescription() {
        return longDescription;
    }
}
