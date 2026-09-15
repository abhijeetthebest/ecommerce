<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<%@ page import="com.ecommerce.presentation.constants.NavConstants" %>
<%@ page errorPage="../error.jsp"%>

<template:insert template='/ecomTemplate.jsp'>
  <template:put name='title' content='maintain customer - order history' direct='true'/>
  <template:put name='navList' content='[["maintain customer", ""], ["order history",""]]' direct='true'/>
  <template:put name='content' content='/customer/customerMaintenanceHeader.jsp' altResourceForPerms='/customer/maintainOrderHistoryContent.jsp'/>
  <template:put name='content' content='/customer/maintainOrderHistoryContent.jsp'/>
  <template:put name='navButton' content='<%=NavConstants.NAV_CUSTOMER%>'/>
</template:insert>
