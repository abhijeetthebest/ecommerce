package com.ecommerce.presentation.tag.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.ecommerce.presentation.util.Logger;

/**
 * Custom tag for putting content in templates.
 */
public class PutTag extends BodyTagSupport {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String content;
    private boolean direct;
    private String altResourceForPerms;
    
    /**
     * Process the start tag.
     * 
     * @return EVAL_BODY_BUFFERED to evaluate the body
     * @throws JspException If an error occurs during tag processing
     */
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }
    
    /**
     * Process the end tag.
     * 
     * @return EVAL_PAGE to continue processing the page
     * @throws JspException If an error occurs during tag processing
     */
    public int doEndTag() throws JspException {
        try {
            // Get the parent insert tag
            InsertTag parent = (InsertTag) findAncestorWithClass(this, InsertTag.class);
            
            if (parent == null) {
                throw new JspException("PutTag must be nested within InsertTag");
            }
            
            // Add parameter to parent
            if (content != null) {
                // Use content attribute
                if (direct) {
                    parent.addParameter(name, content);
                } else {
                    parent.addParameter(name, content);
                }
            } else if (bodyContent != null) {
                // Use body content
                parent.addParameter(name, bodyContent.getString().trim());
            }
            
            return EVAL_PAGE;
        } catch (Exception e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "doEndTag", 
                    "Error processing put tag: " + e.getMessage());
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
    
    /**
     * Set the content.
     * 
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * Set whether the content is direct.
     * 
     * @param direct Whether the content is direct
     */
    public void setDirect(String direct) {
        this.direct = "true".equalsIgnoreCase(direct);
    }
    
    /**
     * Set the alternative resource for permissions.
     * 
     * @param altResourceForPerms The alternative resource for permissions
     */
    public void setAltResourceForPerms(String altResourceForPerms) {
        this.altResourceForPerms = altResourceForPerms;
    }
}
