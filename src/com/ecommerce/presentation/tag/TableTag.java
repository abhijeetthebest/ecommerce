package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering tables.
 */
public class TableTag extends BodyTagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String tableType;
    
    /**
     * Process the start tag.
     * 
     * @return EVAL_BODY_BUFFERED to evaluate the body
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            if ("buttons".equals(tableType)) {
                out.println("<table class=\"buttons\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            } else {
                out.println("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            }
            
            return EVAL_BODY_BUFFERED;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering table tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Process the end tag.
     * 
     * @return EVAL_PAGE to continue processing the page
     * @throws JspException If an error occurs during tag processing
     */
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            out.println("</table>");
            
            return EVAL_PAGE;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doEndTag", 
                    "Error rendering table tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the table type.
     * 
     * @param tableType The table type
     */
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
}
