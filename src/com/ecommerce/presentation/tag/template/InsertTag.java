package com.ecommerce.presentation.tag.template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for inserting templates.
 */
public class InsertTag extends BodyTagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String template;
    private Map<String, Object> parameters;
    
    /**
     * Construct a new insert tag.
     */
    public InsertTag() {
        parameters = new HashMap<>();
    }
    
    /**
     * Process the start tag.
     * 
     * @return EVAL_BODY_INCLUDE to evaluate the body
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }
    
    /**
     * Process the end tag.
     * 
     * @return EVAL_PAGE to continue processing the page
     * @throws JspException If an error occurs during tag processing
     */
    public int doEndTag() throws JspException {
        try {
            // Store parameters in request
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                pageContext.getRequest().setAttribute(entry.getKey(), entry.getValue());
            }
            
            // Include the template
            pageContext.include(template);
            
            // Clear parameters
            parameters.clear();
            
            return EVAL_PAGE;
        } catch (ServletException | IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doEndTag", 
                    "Error processing insert tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the template.
     * 
     * @param template The template
     */
    public void setTemplate(String template) {
        this.template = template;
    }
    
    /**
     * Add a parameter.
     * 
     * @param name The parameter name
     * @param value The parameter value
     */
    public void addParameter(String name, Object value) {
        parameters.put(name, value);
    }
}
