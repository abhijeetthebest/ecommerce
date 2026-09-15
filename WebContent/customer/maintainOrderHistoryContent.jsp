<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.view.customer.ViewOrderHistoryVO" %>
<%@ page import="com.ecommerce.presentation.context.WindowContext" %>
<%@ page import="com.ecommerce.presentation.constants.WebConstants" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<%
    ViewOrderHistoryVO vo = null;
    WindowContext ctx = (WindowContext) pageContext.getAttribute(WebConstants.WIN_CONTEXT_ID, PageContext.REQUEST_SCOPE);
    vo = (ViewOrderHistoryVO) ctx.getValueObject(ctx.getView().getValueObjectResultKey());
    boolean external = vo.isExternal();
%>

<ecom:form name="resultsForm2" action="control" flow="CustomerMaintenance" flowAction="OrderHistoryEdit" method="post" scope="session" validate="false">
    <ecom:table>
        <TR class="e">
            <TD nowrap>MAINTAIN ORDER HISTORY</TD>
            <TD nowrap align="right">[<A href="javascript:performOrderHistoryAction('OrderHistoryAdd2');" class="linkonDark">add order history</A>] 
            <% if(external){%>[<A href="javascript:performOrderHistoryAction('OrderHistoryMaintain');" class="linkonDark">remove EXTERNAL order history</A>]<%}else{%>
            [<A href="javascript:performOrderHistoryAction('OrderHistoryIncludeExternal');" class="linkonDark">view EXTERNAL order history</A>]<%}%> 
            [<A href="javascript:returnToCustomer();" class="linkonDark">RETURN to customer</A>]</TD>
        </TR>
    </ecom:table>
    
    <!-- Results table for order history entries -->
    <ecom:resultsTable tableName="CUSTOMER_ORDER_HISTORY" tableClass="softresults" rowClass="tiny" xmlDescriptor="orderHistoryList.xml" mode="table" noResultsText="NO ORDER HISTORY"/>
    
    <ecom:hidden property="orderHistoryId" value=""></ecom:hidden>
</ecom:form>

<script type="text/javascript">
function performOrderHistoryAction(actionName) {
    document.resultsForm2.<%=WebConstants.ACTION_ID%>.value=actionName;
    go(document.resultsForm2);
}

function returnToCustomer() {
    document.resultsForm2.<%=WebConstants.ACTION_ID%>.value="DisplayCustomerSummary";
    go(document.resultsForm2);
}

function editOrderHistory(orderHistoryId) {
    document.resultsForm2.orderHistoryId.value = orderHistoryId;
    document.resultsForm2.<%=WebConstants.ACTION_ID%>.value="OrderHistoryEdit";
    go(document.resultsForm2);
}
</script>
