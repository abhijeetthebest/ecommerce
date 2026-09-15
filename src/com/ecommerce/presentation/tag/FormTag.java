package com.ecommerce.presentation.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.ecommerce.presentation.constants.WebConstants;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for rendering forms.
 */
public class FormTag extends BodyTagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String action;
    private String flow;
    private String flowAction;
    private String method;
    private String scope;
    private String validate;
    
    /**
     * Process the start tag.
     * 
     * @return EVAL_BODY_BUFFERED to evaluate the body
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            
            out.println("<form name=\"" + name + "\" action=\"" + action + "\" method=\"" + method + "\">");
            out.println("<input type=\"hidden\" name=\"" + WebConstants.FLOW_ID + "\" value=\"" + flow + "\">");
            out.println("<input type=\"hidden\" name=\"" + WebConstants.ACTION_ID + "\" value=\"" + flowAction + "\">");
            
            return EVAL_BODY_BUFFERED;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doStartTag", 
                    "Error rendering form tag: " + e.getMessage());
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
            
            out.println("</form>");
            
            return EVAL_PAGE;
        } catch (IOException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doEndTag", 
                    "Error rendering form tag: " + e.getMessage());
            throw new JspException(e.getMessage());
        }
    }
    
    /**
     * Set the form name.
     * 
     * @param name The form name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the form action.
     * 
     * @param action The form action
     */
    public void setAction(String action) {
        this.action = action;
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
    
    /**
     * Set the form method.
     * 
     * @param method The form method
     */
    public void setMethod(String method) {
        this.method = method;
    }
    
    /**
     * Set the form scope.
     * 
     * @param scope The form scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    /**
     * Set whether to validate the form.
     * 
     * @param validate Whether to validate the form
     */
    public void setValidate(String validate) {
        this.validate = validate;
    }
}
