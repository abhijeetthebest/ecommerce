<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.view.customer.CustomerSummaryVO" %>
<%@ page import="com.ecommerce.presentation.context.WindowContext" %>
<%@ page import="com.ecommerce.presentation.constants.WebConstants" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<%
    WindowContext ctx = (WindowContext) pageContext.getAttribute(WebConstants.WIN_CONTEXT_ID, PageContext.REQUEST_SCOPE);
    CustomerSummaryVO summaryVO = (CustomerSummaryVO) ctx.getValueObject(ctx.getView().getValueObjectResultKey());
    
    boolean primaryBadAddress = false;
    boolean shippingBadAddress = false;
    boolean billingBadAddress = false;
    String CRMUrl = "https://crm.example.com/customer?id=";    
%>

<ecom:table>
    <tr class="e">
        <td> CUSTOMER SUMMARY&nbsp;
        </td>
        <td align="right">
                [<a href="javascript:performCustomerAction('RetrieveAddressInfoNavHist_profile');" class="linkonDark">view address history</a>]
                [<a href="javascript:dataPoint('<%=summaryVO.getRecommendationEngineURL()%>');" class="linkOnDark">product recommendations</a>]
                <% if (!summaryVO.isProspect()) {%>
                [<a href="javascript:sendEmail('<%=CRMUrl%>');" class="linkOnDark">send email</a>]
                <% } %>
                [<a href="javascript:searchCustomerEmail(2,'0');" class="linkOnDark">email history</a>]
        </td>
    </tr>
</ecom:table>

<ecom:table>
    <tr class="listhead">
        <td nowrap>Customer</td>
        <td nowrap>DOB/Age/Joined Date</td>        
        <td nowrap>Primary Address</td>
        <td nowrap>Shipping Address</td>
        <td nowrap>Billing Address</td>
        <td nowrap>Phone/Email</td>
        <td nowrap>Customer<br />Type</td>
        <td nowrap>Loyalty<br />Level</td>
        <td nowrap>Marketing<br />Opt-In</td>
    </tr>
    <tr class="tiny">
        <td valign=top nowrap>#<ecom:label property="customerCode"/>&nbsp;<ecom:label property="customerName"/><br>
            <% if (("Y").equalsIgnoreCase(summaryVO.getTestCustomerIndicator())) { %>
                <span style="color: red; font-weight: bold">TEST CUSTOMER</span>
            <% } %>
        </td>
        <td valign=top nowrap><ecom:label property="customerBirthDate"/><br><ecom:label property="customerAge"/><br><b><ecom:label property="customerJoinedDate"/></b><br>
        <ecom:label property="preferredLanguage"/>
            <% if (summaryVO.getSpecialAssistanceIndicator().length > 0 && ("Y").equalsIgnoreCase(summaryVO.getSpecialAssistanceIndicator()[0])) { %>
                <br><span>SPECIAL ASSISTANCE</span>
            <% } %>
        </td>
        
        <td valign=top nowrap>
            <% if (primaryBadAddress) { %>
                <span style="color: red; font-weight: bold">BAD ADDRESS</span><br>
            <% } %>
            <ecom:label property="primaryAddress"/><br>
            <ecom:label property="primaryCity"/>, <ecom:label property="primaryState"/> <ecom:label property="primaryZip"/>
        </td>
        
        <td valign=top nowrap>
            <% if (shippingBadAddress) { %>
                <span style="color: red; font-weight: bold">BAD ADDRESS</span><br>
            <% } %>
            <ecom:label property="shippingAddress"/><br>
            <ecom:label property="shippingCity"/>, <ecom:label property="shippingState"/> <ecom:label property="shippingZip"/>
        </td>
        
        <td valign=top nowrap>
            <% if (billingBadAddress) { %>
                <span style="color: red; font-weight: bold">BAD ADDRESS</span><br>
            <% } %>
            <ecom:label property="billingAddress"/><br>
            <ecom:label property="billingCity"/>, <ecom:label property="billingState"/> <ecom:label property="billingZip"/>
        </td>
        
        <td valign=top nowrap>
            <ecom:label property="dayPhone"/><br>
            <ecom:label property="eveningPhone"/><br>
            <ecom:label property="mobilePhone"/><br>
            <ecom:label property="email"/>
        </td>
        
        <td valign=top nowrap>
            <ecom:label property="customerType"/>
        </td>
        
        <td valign=top nowrap>
            <ecom:label property="loyaltyLevel"/>
        </td>
        
        <td valign=top nowrap>
            <ecom:label property="marketingOptIn"/>
        </td>
    </tr>
</ecom:table>

<ecom:form name="customerSummaryForm" action="control" flow="CustomerMaintenance" flowAction="DisplayCustomerSummary" method="post" scope="session" validate="false">
    <ecom:hidden property="customerId" value="<%=summaryVO.getCustomerId()%>"/>
</ecom:form>

<script type="text/javascript">
function performCustomerAction(actionName) {
    document.customerSummaryForm.<%=WebConstants.ACTION_ID%>.value=actionName;
    go(document.customerSummaryForm);
}

function sendEmail(crm_url) {
    dataPoint(crm_url + document.customerSummaryForm.customerId.value + "&entityType=customer");
}

function searchCustomerEmail(associationType, applicationId) {
    document.searchEmailHistoryForm.associationType.value = associationType;
    document.searchEmailHistoryForm.applicationId.value = applicationId;
    document.searchEmailHistoryForm.customerId.value = document.customerSummaryForm.customerId.value;
    go(document.searchEmailHistoryForm);
}
</script>
