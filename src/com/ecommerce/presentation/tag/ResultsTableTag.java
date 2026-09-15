package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering results tables.
 */
public class ResultsTableTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String tableName;
    private String displayHeader;
    private String tableClass;
    private String rowClass;
    private String xmlDescriptor;
    private String mode;
    private String noResultsText;
    private String maxRows;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            // For simplicity, just render a mock results table
            out.println("<table class=\"" + tableClass + "\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            
            if ("yes".equals(displayHeader)) {
                out.println("<tr class=\"listhead\">");
                out.println("<td>Column 1</td>");
                out.println("<td>Column 2</td>");
                out.println("<td>Column 3</td>");
                out.println("</tr>");
            }
            
            // Check if there are results
            boolean hasResults = false;
            
            // If no results, show the no results text
            if (!hasResults) {
                out.println("<tr class=\"" + rowClass + "\">");
                out.println("<td colspan=\"3\">" + noResultsText + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering results table tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the table name.
     * 
     * @param tableName The table name
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    /**
     * Set whether to display the header.
     * 
     * @param displayHeader Whether to display the header
     */
    public void setDisplayHeader(String displayHeader) {
        this.displayHeader = displayHeader;
    }
    
    /**
     * Set the table class.
     * 
     * @param tableClass The table class
     */
    public void setTableClass(String tableClass) {
        this.tableClass = tableClass;
    }
    
    /**
     * Set the row class.
     * 
     * @param rowClass The row class
     */
    public void setRowClass(String rowClass) {
        this.rowClass = rowClass;
    }
    
    /**
     * Set the XML descriptor.
     * 
     * @param xmlDescriptor The XML descriptor
     */
    public void setXmlDescriptor(String xmlDescriptor) {
        this.xmlDescriptor = xmlDescriptor;
    }
    
    /**
     * Set the mode.
     * 
     * @param mode The mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    /**
     * Set the no results text.
     * 
     * @param noResultsText The no results text
     */
    public void setNoResultsText(String noResultsText) {
        this.noResultsText = noResultsText;
    }
    
    /**
     * Set the maximum number of rows.
     * 
     * @param maxRows The maximum number of rows
     */
    public void setMaxRows(String maxRows) {
        this.maxRows = maxRows;
    }
}
