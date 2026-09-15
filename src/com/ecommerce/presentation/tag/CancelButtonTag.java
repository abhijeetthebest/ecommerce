package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.ecommerce.presentation.constants.WebConstants;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering cancel buttons.
 */
public class CancelButtonTag extends TagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String flow;
    private String flowAction;
    
    /**
     * Process the start tag.
     * 
     * @return SKIP_BODY to skip the body processing
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            out.println("<input type=\"button\" value=\"Cancel\" onclick=\"javascript:cancelAction('" + 
                    flow + "', '" + flowAction + "');\" class=\"button\">");
            
            return SKIP_BODY;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering cancel button tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the flow.
     * 
     * @param flow The flow
     */
    public void setFlow(String flow) {
        this.flow = flow;
    }
    
    /**
     * Set the flow action.
     * 
     * @param flowAction The flow action
     */
    public void setFlowAction(String flowAction) {
        this.flowAction = flowAction;
    }
}
