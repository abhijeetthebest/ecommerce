package com.ecommerce.presentation.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.constants.WebConstants;
import com.ecommerce.presentation.util.Logger;
import com.ecommerce.view.customer.OrderHistoryVO;

/**
 * Custom tag for rendering order history forms.
 */
public class OrderHistoryTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private int orderEntryType;
    private String orderEntryIdFieldName;
    private boolean isRequired;
    private boolean workQueueDisabled;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            // Get the order history VO from the context
            WindowContext ctx = (WindowContext) pageContext.getAttribute(
                    WebConstants.WIN_CONTEXT_ID, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
            OrderHistoryVO vo = (OrderHistoryVO) ctx.getValueObject(ctx.getView().getValueObjectResultKey());
            
            // Format the current date
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String currentDate = dateFormat.format(new Date());
            
            // Render order history fields
            out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            out.println("<tr><td class='listsubhead' colspan='2'>ORDER HISTORY INFORMATION</td></tr>");
            
            // Order date field
            out.println("<tr>");
            out.println("<td class='label' width='20%'>Order Date:</td>");
            out.println("<td class='field'>");
            out.println("<input type='text' name='orderDate' value='" + 
                    (vo != null && vo.getOrderDate() != null ? 
                            dateFormat.format(vo.getOrderDate()) : currentDate) + 
                    "' size='10' maxlength='10'>");
            if (isRequired) {
                out.println("<span class='required'>*</span>");
            }
            out.println("</td>");
            out.println("</tr>");
            
            // Representative field
            out.println("<tr>");
            out.println("<td class='label'>Representative:</td>");
            out.println("<td class='field'>");
            out.println("<input type='text' name='representative' value='" + 
                    (vo != null && vo.getRepresentative() != null ? 
                            vo.getRepresentative() : "") + 
                    "' size='30' maxlength='50'>");
            if (isRequired) {
                out.println("<span class='required'>*</span>");
            }
            out.println("</td>");
            out.println("</tr>");
            
            // Order type field
            out.println("<tr>");
            out.println("<td class='label'>Order Type:</td>");
            out.println("<td class='field'>");
            out.println("<select name='orderTypeId'>");
            out.println("<option value=''>-- Select Order Type --</option>");
            out.println("<option value='1'" + 
                    (vo != null && vo.getOrderTypeId() == 1 ? " selected" : "") + 
                    ">New Order</option>");
            out.println("<option value='2'" + 
                    (vo != null && vo.getOrderTypeId() == 2 ? " selected" : "") + 
                    ">Order Update</option>");
            out.println("<option value='3'" + 
                    (vo != null && vo.getOrderTypeId() == 3 ? " selected" : "") + 
                    ">Order Cancellation</option>");
            out.println("<option value='4'" + 
                    (vo != null && vo.getOrderTypeId() == 4 ? " selected" : "") + 
                    ">Return/Refund</option>");
            out.println("<option value='5'" + 
                    (vo != null && vo.getOrderTypeId() == 5 ? " selected" : "") + 
                    ">Shipping Inquiry</option>");
            out.println("</select>");
            if (isRequired) {
                out.println("<span class='required'>*</span>");
            }
            out.println("</td>");
            out.println("</tr>");
            
            // Note field
            out.println("<tr>");
            out.println("<td class='label'>Note:</td>");
            out.println("<td class='field'>");
            out.println("<textarea name='note' rows='5' cols='50'>" + 
                    (vo != null && vo.getNote() != null ? vo.getNote() : "") + 
                    "</textarea>");
            if (isRequired) {
                out.println("<span class='required'>*</span>");
            }
            out.println("</td>");
            out.println("</tr>");
            
            // Order number field
            out.println("<tr>");
            out.println("<td class='label'>Order Number:</td>");
            out.println("<td class='field'>");
            out.println("<input type='text' name='orderNumber' value='" + 
                    (vo != null && vo.getOrderNumber() != null ? 
                            vo.getOrderNumber() : "") + 
                    "' size='20' maxlength='20'>");
            out.println("</td>");
            out.println("</tr>");
            
            // Hidden fields
            out.println("<input type='hidden' name='" + orderEntryIdFieldName + "' value='" + 
                    (vo != null ? vo.getOrderEntryId() : "") + "'>");
            out.println("<input type='hidden' name='orderEntryTypeId' value='" + orderEntryType + "'>");
            
            if (vo != null && vo.getOrderHistoryId() > 0) {
                out.println("<input type='hidden' name='orderHistoryId' value='" + 
                        vo.getOrderHistoryId() + "'>");
            }
            
            out.println("</table>");
            
            // Render work queue fields if not disabled
            if (!workQueueDisabled) {
                out.println("<br>");
                out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
                out.println("<tr><td class='listsubhead' colspan='2'>WORK QUEUE INFORMATION</td></tr>");
                
                // Create work queue checkbox
                out.println("<tr>");
                out.println("<td class='label' width='20%'>Create Work Queue:</td>");
                out.println("<td class='field'>");
                out.println("<input type='checkbox' name='createWorkQueue' value='true'" + 
                        (vo != null && vo.isCreateWorkQueue() ? " checked" : "") + 
                        " onclick='toggleWorkQueueFields(this.checked);'>");
                out.println("</td>");
                out.println("</tr>");
                
                // Work queue type field
                out.println("<tr class='workQueueField'>");
                out.println("<td class='label'>Work Queue Type:</td>");
                out.println("<td class='field'>");
                out.println("<select name='workQueueTypeId'>");
                out.println("<option value=''>-- Select Work Queue Type --</option>");
                out.println("<option value='1'" + 
                        (vo != null && vo.getWorkQueueTypeId() == 1 ? " selected" : "") + 
                        ">Missing Required Information</option>");
                out.println("<option value='2'" + 
                        (vo != null && vo.getWorkQueueTypeId() == 2 ? " selected" : "") + 
                        ">Order Issue</option>");
                out.println("<option value='3'" + 
                        (vo != null && vo.getWorkQueueTypeId() == 3 ? " selected" : "") + 
                        ">Billing Issue</option>");
                out.println("<option value='4'" + 
                        (vo != null && vo.getWorkQueueTypeId() == 4 ? " selected" : "") + 
                        ">Shipping Issue</option>");
                out.println("<option value='5'" + 
                        (vo != null && vo.getWorkQueueTypeId() == 5 ? " selected" : "") + 
                        ">Customer Service Issue</option>");
                out.println("</select>");
                out.println("<span class='required'>*</span>");
                out.println("</td>");
                out.println("</tr>");
                
                // Work queue reason field
                out.println("<tr class='workQueueField'>");
                out.println("<td class='label'>Work Queue Reason:</td>");
                out.println("<td class='field'>");
                out.println("<select name='workQueueReasonId'>");
                out.println("<option value=''>-- Select Work Queue Reason --</option>");
                out.println("<option value='101'" + 
                        (vo != null && vo.getWorkQueueReasonId() == 101 ? " selected" : "") + 
                        ">Missing Payment Information</option>");
                out.println("<option value='102'" + 
                        (vo != null && vo.getWorkQueueReasonId() == 102 ? " selected" : "") + 
                        ">Missing Shipping Information</option>");
                out.println("<option value='103'" + 
                        (vo != null && vo.getWorkQueueReasonId() == 103 ? " selected" : "") + 
                        ">Missing Contact Information</option>");
                out.println("<option value='201'" + 
                        (vo != null && vo.getWorkQueueReasonId() == 201 ? " selected" : "") + 
                        ">Order Verification Required</option>");
                out.println("<option value='202'" + 
                        (vo != null && vo.getWorkQueueReasonId() == 202 ? " selected" : "") + 
                        ">Order Cancellation Request</option>");
                out.println("</select>");
                out.println("<span class='required'>*</span>");
                out.println("</td>");
                out.println("</tr>");
                
                // Work queue due date field
                out.println("<tr class='workQueueField'>");
                out.println("<td class='label'>Due Date:</td>");
                out.println("<td class='field'>");
                out.println("<input type='text' name='workQueueDueDate' value='" + 
                        (vo != null && vo.getWorkQueueDueDate() != null ? 
                                dateFormat.format(vo.getWorkQueueDueDate()) : "") + 
                        "' size='10' maxlength='10'>");
                out.println("<span class='required'>*</span>");
                out.println("</td>");
                out.println("</tr>");
                
                // Work queue notes field
                out.println("<tr class='workQueueField'>");
                out.println("<td class='label'>Work Queue Notes:</td>");
                out.println("<td class='field'>");
                out.println("<textarea name='workQueueNotes' rows='3' cols='50'>" + 
                        (vo != null && vo.getWorkQueueNotes() != null ? 
                                vo.getWorkQueueNotes() : "") + 
                        "</textarea>");
                out.println("</td>");
                out.println("</tr>");
                
                out.println("</table>");
                
                // JavaScript to toggle work queue fields
                out.println("<script type='text/javascript'>");
                out.println("function toggleWorkQueueFields(show) {");
                out.println("    var fields = document.getElementsByClassName('workQueueField');");
                out.println("    for (var i = 0; i < fields.length; i++) {");
                out.println("        fields[i].style.display = show ? '' : 'none';");
                out.println("    }");
                out.println("}");
                out.println("toggleWorkQueueFields(" + 
                        (vo != null && vo.isCreateWorkQueue() ? "true" : "false") + ");");
                out.println("</script>");
            }
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering order history tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the order entry type.
     * 
     * @param orderEntryType The order entry type
     */
    public void setOrderEntryType(int orderEntryType) {
        this.orderEntryType = orderEntryType;
    }
    
    /**
     * Set the order entry ID field name.
     * 
     * @param orderEntryIdFieldName The order entry ID field name
     */
    public void setOrderEntryIdFieldName(String orderEntryIdFieldName) {
        this.orderEntryIdFieldName = orderEntryIdFieldName;
    }
    
    /**
     * Set whether fields are required.
     * 
     * @param isRequired True if fields are required, false otherwise
     */
    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
    
    /**
     * Set whether work queue fields are disabled.
     * 
     * @param workQueueDisabled True if work queue fields are disabled, false otherwise
     */
    public void setWorkQueueDisabled(boolean workQueueDisabled) {
        this.workQueueDisabled = workQueueDisabled;
    }
}
