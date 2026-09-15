<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.view.customer.CustomerSummaryVO" %>
<%@ page import="com.ecommerce.presentation.context.WindowContext" %>
<%@ page import="com.ecommerce.presentation.constants.WebConstants" %>
<%@ page import="com.ecommerce.presentation.constants.ResultTableConstants" %>
<%@ page import="com.ecommerce.business.constants.CustomerType" %>
<%@ page import="javax.servlet.jsp.PageContext" %>

<% 
    WindowContext ctx = (WindowContext) pageContext.getAttribute(WebConstants.WIN_CONTEXT_ID, PageContext.REQUEST_SCOPE);
    CustomerSummaryVO customerSummaryVO = (CustomerSummaryVO) ctx.getValueObject(ctx.getView().getValueObjectResultKey());
    boolean showB2B = true;
    CustomerType b2cType = CustomerType.get(CustomerType.ECOM_TYPE_B2C);
    showB2B = !(customerSummaryVO.getCustomerType().equals(b2cType.getLongDescription()));
    String CRMUrl = "https://crm.example.com/customer?id=" + customerSummaryVO.getCustomerId();
%>

<!-- Profile Summary Section -->
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>PROFILE SUMMARY</td>
        <td class="listsubhead" nowrap align="right">[<a href="javascript:performCustomerAction('UpdateCustomerProfile');" class="linkondark">update profile</a>]</td>
    </tr>
</table>
<ecom:resultsTable maxRows="5" tableName="<%=ResultTableConstants.CUSTOMER_PROFILE_PANEL%>" displayHeader="yes" tableClass="softresults" rowClass="tiny" xmlDescriptor="customerProfile.xml" mode="table" noResultsText="NO PROFILE EXISTS"/>

<!-- Active Preferences Section -->
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>ACTIVE PREFERENCES</td>
        <td class="listsubhead" nowrap align="right">[<a href="javascript:performCustomerAction('MaintainPreferences');" class="linkondark">maintain preferences</a>]</td>
    </tr>
</table>
<ecom:resultsTable maxRows="5" tableName="<%=ResultTableConstants.CUSTOMER_PREFERENCES_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="customerPreferences.xml" mode="table" noResultsText="NO PREFERENCES EXIST"/>

<!-- Order History Section -->
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>ORDER HISTORY SUMMARY</td>
        <td class="listsubhead" nowrap align="right">
            [<a href="javascript:performCustomerAction('OrderHistoryAdd');" class="linkonDark">add order history</a>]
            [<a href="javascript:performCustomerAction('OrderHistoryMaintain');" class="linkonDark">maintain order history</a>]
            [<a href="javascript:performCustomerAction('OrderHistoryWQAdd');" class="linkonDark">create work queue item</a>]
            [<a href="javascript:openChildWindow('<%=CRMUrl%>');" class="linkonDark">view customer interaction</a>]
        </td>
    </tr>
</table>
<ecom:resultsTable maxRows="3" tableName="<%=ResultTableConstants.ORDER_HISTORY_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="orderHistory.xml" mode="table" noResultsText="NO ORDER HISTORY"/>

<!-- Payment Methods Section -->
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>PAYMENT METHODS</td>
        <td class="listsubhead" nowrap align="right">
            [<a href="javascript:performCustomerAction('AddPaymentMethod');" class="linkonDark">add payment method</a>]
            [<a href="javascript:performCustomerAction('MaintainPaymentMethods');" class="linkonDark">maintain payment methods</a>]
        </td>
    </tr>
</table>
<ecom:resultsTable maxRows="3" tableName="<%=ResultTableConstants.PAYMENT_METHODS_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="paymentMethods.xml" mode="table" noResultsText="NO PAYMENT METHODS"/>

<!-- Order Summary Section -->
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>ORDER SUMMARY</td>
        <td class="listsubhead" nowrap align="right">
            [<a href="javascript:performCustomerAction('CreateOrder');" class="linkonDark">create new order</a>]
        </td>
    </tr>
</table>
<ecom:resultsTable maxRows="5" tableName="<%=ResultTableConstants.ORDERS_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="orders.xml" mode="table" noResultsText="NO ORDERS"/>

<!-- Wishlist Summary Section -->
<% if (!showB2B) { %>
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>WISHLIST SUMMARY</td>
        <td class="listsubhead" nowrap align="right">
            [<a href="javascript:performCustomerAction('ViewWishlist');" class="linkonDark">view wishlist</a>]
        </td>
    </tr>
</table>
<ecom:resultsTable maxRows="3" tableName="<%=ResultTableConstants.WISHLIST_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="wishlist.xml" mode="table" noResultsText="NO WISHLIST ITEMS"/>
<% } %>

<!-- B2B Section -->
<% if (showB2B) { %>
<table width='100%' border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td class="listsubhead" nowrap>BUSINESS ACCOUNT SUMMARY</td>
        <td class="listsubhead" nowrap align="right">
            [<a href="javascript:performCustomerAction('MaintainBusinessAccount');" class="linkonDark">maintain business account</a>]
        </td>
    </tr>
</table>
<ecom:resultsTable maxRows="3" tableName="<%=ResultTableConstants.BUSINESS_ACCOUNT_PANEL%>" tableClass="softresults" rowClass="tiny" xmlDescriptor="businessAccount.xml" mode="table" noResultsText="NO BUSINESS ACCOUNT INFORMATION"/>
<% } %>
