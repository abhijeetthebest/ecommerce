<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.view.customer.CustomerSummaryVO" %>
<%@ page import="com.ecommerce.presentation.context.WindowContext" %>
<%@ page import="com.ecommerce.presentation.constants.WebConstants" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<%
    WindowContext ctx = (WindowContext) pageContext.getAttribute(WebConstants.WIN_CONTEXT_ID, PageContext.REQUEST_SCOPE);
    CustomerSummaryVO summaryVO = (CustomerSummaryVO) ctx.getValueObject("customermaintenance.customerSummaryVO");
%>

<ecom:table>
    <tr class="e">
        <td nowrap>CUSTOMER: <ecom:label property="customerName" valueObject="<%=summaryVO%>"/> (#<ecom:label property="customerCode" valueObject="<%=summaryVO%>"/>)</td>
        <td nowrap align="right">[<A href="javascript:returnToCustomer();" class="linkonDark">RETURN to customer</A>]</td>
    </tr>
</ecom:table>

<script type="text/javascript">
function returnToCustomer() {
    document.location.href = "<%=request.getContextPath()%>/control?flow=CustomerMaintenance&flowAction=DisplayCustomerSummary&customerId=<%=summaryVO.getCustomerId()%>";
}
</script>
