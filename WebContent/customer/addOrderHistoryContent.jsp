<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.view.customer.OrderHistoryVO" %>
<%@ page import="com.ecommerce.presentation.context.WindowContext" %>
<%@ page import="com.ecommerce.presentation.constants.WebConstants" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<%
    OrderHistoryVO vo = null;
    WindowContext ctx = (WindowContext) pageContext.getAttribute(WebConstants.WIN_CONTEXT_ID, PageContext.REQUEST_SCOPE);
    vo = (OrderHistoryVO) ctx.getValueObject(ctx.getView().getValueObjectResultKey());
    String flowAction = "OrderHistoryAddSave";
    String cancelAction = "Cancel";
    if(vo != null) {        
        if(vo.getMaintainScreen()) {
            flowAction = "OrderHistoryAddSave2";
            cancelAction = "CancelAddEditOrderHistory";
        }
    }
%>

<ecom:form name="addOrderHistoryForm" action="control" flow="CustomerMaintenance" flowAction="<%=flowAction%>" method="post" scope="session" validate="false">
<span onKeyPress="javascript:if ((window.event.keyCode == 13) && (document.getElementById('btnSave')!=null)) { document.getElementById('btnSave').click(); }">
<ecom:orderHistory orderEntryType="3" orderEntryIdFieldName="orderEntryId" isRequired="true" workQueueDisabled="true" />    
</span>
</ecom:form>

<br>
<ecom:table tableType="buttons">
    <tr>
        <td><ecom:savebutton formName="addOrderHistoryForm"/></td>
        <td><ecom:cancelbutton flow="CustomerMaintenance" flowAction="<%=cancelAction%>"/></td>
    </tr>
</ecom:table>
