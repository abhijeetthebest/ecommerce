package com.ecommerce.presentation.tag;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.constants.WebConstants;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering labels.
 */
public class LabelTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String property;
    private Object valueObject;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            // Get the value object
            Object vo = valueObject;
            
            if (vo == null) {
                // Get the value object from the window context
                WindowContext ctx = (WindowContext) pageContext.getAttribute(
                        WebConstants.WIN_CONTEXT_ID, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
                
                if (ctx != null) {
                    vo = ctx.getValueObject(ctx.getView().getValueObjectResultKey());
                }
            }
            
            // Get the property value
            String value = getPropertyValue(vo, property);
            
            // Write the value
            out.print(value != null ? value : "");
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering label tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Get the value of a property from an object.
     * 
     * @param obj The object
     * @param property The property name
     * @return The property value
     */
    private String getPropertyValue(Object obj, String property) {
        if (obj == null || property == null) {
            return "";
        }
        
        try {
            // Get the getter method
            String getterName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
            Method getter = obj.getClass().getMethod(getterName);
            
            // Invoke the getter
            Object value = getter.invoke(obj);
            
            return value != null ? value.toString() : "";
        } catch (Exception e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "getPropertyValue", 
                    "Error getting property value: " + e.getMessage());
            return "";
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
     * Set the value object.
     * 
     * @param valueObject The value object
     */
    public void setValueObject(Object valueObject) {
        this.valueObject = valueObject;
    }
}
