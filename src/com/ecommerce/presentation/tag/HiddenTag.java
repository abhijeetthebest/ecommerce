package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering hidden fields.
 */
public class HiddenTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String property;
    private String value;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            out.println("<input type=\"hidden\" name=\"" + property + "\" value=\"" + value + "\">");
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering hidden tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the property name.
     * 
     * @param property The property name
     */
    public void setProperty(String property) {
        this.property = property;
    }
    
    /**
     * Set the value.
     * 
     * @param value The value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
