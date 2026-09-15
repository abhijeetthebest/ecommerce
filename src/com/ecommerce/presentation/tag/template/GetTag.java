package com.ecommerce.presentation.tag.template;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for getting content from templates.
 */
public class GetTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            // Get the parameter from request
            Object value = pageContext.getRequest().getAttribute(name);
            
            if (value != null) {
                out.print(value.toString());
            }
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error processing get tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the name.
     * 
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }
}
