package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering save buttons.
 */
public class SaveButtonTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String formName;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            out.println("<input type=\"button\" id=\"btnSave\" value=\"Save\" onclick=\"javascript:go(document." + 
                    formName + ");\" class=\"button\">");
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering save button tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the form name.
     * 
     * @param formName The form name
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }
}
