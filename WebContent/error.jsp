<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>

<template:insert template='/ecomTemplate.jsp'>
  <template:put name='title' content='Error' direct='true'/>
  <template:put name='navList' content='[["Error", ""]]' direct='true'/>
  <template:put name='content'>
    <div class="errorContainer">
      <h1>An Error Has Occurred</h1>
      
      <div class="errorDetails">
        <% if(exception != null) { %>
          <h3>Error Details:</h3>
          <p>Type: <%= exception.getClass().getName() %></p>
          <p>Message: <%= exception.getMessage() %></p>
          
          <h3>Stack Trace:</h3>
          <div class="stackTrace">
            <% 
              java.io.StringWriter stringWriter = new java.io.StringWriter();
              java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
              exception.printStackTrace(printWriter);
              out.println(stringWriter.toString().replace("\n", "<br/>"));
            %>
          </div>
        <% } else { %>
          <p>Sorry, an unexpected error has occurred. Please try again later.</p>
        <% } %>
      </div>
      
      <div class="errorActions">
        <a href="<%=request.getContextPath()%>/index.jsp" class="button">Return to Home Page</a>
        <a href="<%=request.getContextPath()%>/customer/customerService.jsp" class="button">Contact Customer Service</a>
      </div>
    </div>
  </template:put>
</template:insert>
