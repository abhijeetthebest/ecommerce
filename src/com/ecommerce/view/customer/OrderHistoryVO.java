package com.ecommerce.view.customer;

import java.io.Serializable;
import java.util.Date;
import com.ecommerce.view.ValueObject;

/**
 * Value object for order history information.
 */
public class OrderHistoryVO implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private long orderHistoryId;
    private long orderEntryId;
    private int orderEntryTypeId;
    private Date orderDate;
    private String representative;
    private int orderTypeId;
    private String orderTypeDesc;
    private String note;
    private String customerType;
    private String customerNumber;
    private String orderNumber;
    private int recordTypeId;
    private String recordTypeDesc;
    private boolean maintainScreen;
    private boolean webService;
    private String userName;

    // Work queue fields
    private boolean createWorkQueue;
    private int workQueueTypeId;
    private int workQueueReasonId;
    private String workQueueReasonDesc;
    private Date workQueueDueDate;
    private String workQueueNotes;

    /**
     * Default constructor.
     */
    public OrderHistoryVO() {
        // Default constructor
    }

    /**
     * Get the order history ID.
     *
     * @return The order history ID
     */
    public long getOrderHistoryId() {
        return orderHistoryId;
    }

    /**
     * Set the order history ID.
     *
     * @param orderHistoryId The order history ID
     */
    public void setOrderHistoryId(long orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
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
     * Get the order entry type ID.
     *
     * @return The order entry type ID
     */
    public int getOrderEntryTypeId() {
        return orderEntryTypeId;
    }

    /**
     * Set the order entry type ID.
     *
     * @param orderEntryTypeId The order entry type ID
     */
    public void setOrderEntryTypeId(int orderEntryTypeId) {
        this.orderEntryTypeId = orderEntryTypeId;
    }

    /**
     * Get the order date.
     *
     * @return The order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the order date.
     *
     * @param orderDate The order date
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Get the representative.
     *
     * @return The representative
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     * Set the representative.
     *
     * @param representative The representative
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /**
     * Get the order type ID.
     *
     * @return The order type ID
     */
    public int getOrderTypeId() {
        return orderTypeId;
    }

    /**
     * Set the order type ID.
     *
     * @param orderTypeId The order type ID
     */
    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    /**
     * Get the order type description.
     *
     * @return The order type description
     */
    public String getOrderTypeDesc() {
        return orderTypeDesc;
    }

    /**
     * Set the order type description.
     *
     * @param orderTypeDesc The order type description
     */
    public void setOrderTypeDesc(String orderTypeDesc) {
        this.orderTypeDesc = orderTypeDesc;
    }

    /**
     * Get the note.
     *
     * @return The note
     */
    public String getNote() {
        return note;
    }

    /**
     * Set the note.
     *
     * @param note The note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Get the order number.
     *
     * @return The order number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Set the order number.
     *
     * @param orderNumber The order number
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Check if this is a maintain screen.
     *
     * @return True if this is a maintain screen, false otherwise
     */
    public boolean getMaintainScreen() {
        return maintainScreen;
    }

    /**
     * Set whether this is a maintain screen.
     *
     * @param maintainScreen True if this is a maintain screen, false otherwise
     */
    public void setMaintainScreen(boolean maintainScreen) {
        this.maintainScreen = maintainScreen;
    }

    /**
     * Check if this is a web service.
     *
     * @return True if this is a web service, false otherwise
     */
    public boolean isWebService() {
        return webService;
    }

    /**
     * Set whether this is a web service.
     *
     * @param webService True if this is a web service, false otherwise
     */
    public void setWebService(boolean webService) {
        this.webService = webService;
    }

    /**
     * Check if a work queue should be created.
     *
     * @return True if a work queue should be created, false otherwise
     */
    public boolean isCreateWorkQueue() {
        return createWorkQueue;
    }

    /**
     * Set whether a work queue should be created.
     *
     * @param createWorkQueue True if a work queue should be created, false otherwise
     */
    public void setCreateWorkQueue(boolean createWorkQueue) {
        this.createWorkQueue = createWorkQueue;
    }

    /**
     * Get the work queue type ID.
     *
     * @return The work queue type ID
     */
    public int getWorkQueueTypeId() {
        return workQueueTypeId;
    }

    /**
     * Set the work queue type ID.
     *
     * @param workQueueTypeId The work queue type ID
     */
    public void setWorkQueueTypeId(int workQueueTypeId) {
        this.workQueueTypeId = workQueueTypeId;
    }

    /**
     * Get the work queue reason ID.
     *
     * @return The work queue reason ID
     */
    public int getWorkQueueReasonId() {
        return workQueueReasonId;
    }

    /**
     * Set the work queue reason ID.
     *
     * @param workQueueReasonId The work queue reason ID
     */
    public void setWorkQueueReasonId(int workQueueReasonId) {
        this.workQueueReasonId = workQueueReasonId;
    }

    /**
     * Get the work queue reason description.
     *
     * @return The work queue reason description
     */
    public String getWorkQueueReasonDesc() {
        return workQueueReasonDesc;
    }

    /**
     * Set the work queue reason description.
     *
     * @param workQueueReasonDesc The work queue reason description
     */
    public void setWorkQueueReasonDesc(String workQueueReasonDesc) {
        this.workQueueReasonDesc = workQueueReasonDesc;
    }

    /**
     * Get the work queue due date.
     *
     * @return The work queue due date
     */
    public Date getWorkQueueDueDate() {
        return workQueueDueDate;
    }

    /**
     * Set the work queue due date.
     *
     * @param workQueueDueDate The work queue due date
     */
    public void setWorkQueueDueDate(Date workQueueDueDate) {
        this.workQueueDueDate = workQueueDueDate;
    }

    /**
     * Get the work queue notes.
     *
     * @return The work queue notes
     */
    public String getWorkQueueNotes() {
        return workQueueNotes;
    }

    /**
     * Set the work queue notes.
     *
     * @param workQueueNotes The work queue notes
     */
    public void setWorkQueueNotes(String workQueueNotes) {
        this.workQueueNotes = workQueueNotes;
    }

    /**
     * Get the customer type.
     *
     * @return The customer type
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Set the customer type.
     *
     * @param customerType The customer type
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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
}
