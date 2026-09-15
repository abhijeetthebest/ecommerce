package com.ecommerce.view.customer;

import java.io.Serializable;
import java.util.List;
import com.ecommerce.view.ValueObject;

/**
 * Value object for viewing order history.
 */
public class ViewOrderHistoryVO implements ValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long orderEntryId;
    private boolean external;
    private String orderHistoryId;
    private List<OrderHistoryVO> entries;
    
    /**
     * Default constructor.
     */
    public ViewOrderHistoryVO() {
        // Default constructor
    }
    
    /**
     * Get the order entry ID.
     * 
     * @return The order entry ID
     */
    public long getOrderEntryId() {
        return orderEntryId;
    }
    
    /**
     * Set the order entry ID.
     * 
     * @param orderEntryId The order entry ID
     */
    public void setOrderEntryId(long orderEntryId) {
        this.orderEntryId = orderEntryId;
    }
    
    /**
     * Check if external order history is included.
     * 
     * @return True if external order history is included, false otherwise
     */
    public boolean isExternal() {
        return external;
    }
    
    /**
     * Set whether external order history is included.
     * 
     * @param external True if external order history is included, false otherwise
     */
    public void setExternal(boolean external) {
        this.external = external;
    }
    
    /**
     * Get the order history ID.
     * 
     * @return The order history ID
     */
    public String getOrderHistoryId() {
        return orderHistoryId;
    }
    
    /**
     * Set the order history ID.
     * 
     * @param orderHistoryId The order history ID
     */
    public void setOrderHistoryId(String orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }
    
    /**
     * Get the order history entries.
     * 
     * @return The order history entries
     */
    public List<OrderHistoryVO> getEntries() {
        return entries;
    }
    
    /**
     * Set the order history entries.
     * 
     * @param entries The order history entries
     */
    public void setEntries(List<OrderHistoryVO> entries) {
        this.entries = entries;
    }
}
