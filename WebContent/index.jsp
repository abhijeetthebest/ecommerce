<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>

<template:insert template='/ecomTemplate.jsp'>
  <template:put name='title' content='E-commerce Home' direct='true'/>
  <template:put name='navList' content='[["Home", ""]]' direct='true'/>
  <template:put name='content'>
    <div style="text-align: center; padding: 20px;">
      <h1>Welcome to E-commerce Web Application</h1>
      
      <p>This is a demonstration of an e-commerce web application using JSP, servlets, and custom tags.</p>
      
      <div style="margin: 20px 0;">
        <h2>Main Functions</h2>
        
        <div style="display: flex; justify-content: center; flex-wrap: wrap;">
          <div style="width: 200px; margin: 10px; padding: 10px; border: 1px solid #cccccc; border-radius: 5px;">
            <h3>Customer Management</h3>
            <p>Manage customer information, order history, and preferences.</p>
            <p><a href="control?flow=CustomerMaintenance&flowAction=DisplayCustomerSummary&customerId=123" class="button">Go</a></p>
          </div>
          
          <div style="width: 200px; margin: 10px; padding: 10px; border: 1px solid #cccccc; border-radius: 5px;">
            <h3>Catalog Management</h3>
            <p>Manage product catalog, categories, and pricing.</p>
            <p><a href="control?flow=CatalogManagement&flowAction=DisplayCatalogItem&catalogItemId=456" class="button">Go</a></p>
          </div>
          
          <div style="width: 200px; margin: 10px; padding: 10px; border: 1px solid #cccccc; border-radius: 5px;">
            <h3>Order Management</h3>
            <p>Create and manage customer orders.</p>
            <p><a href="control?flow=OrderManagement&flowAction=CreateOrder" class="button">Go</a></p>
          </div>
        </div>
      </div>
      
      <div style="margin: 20px 0;">
        <h2>About This Application</h2>
        <p>This e-commerce web application demonstrates the use of:</p>
        <ul style="display: inline-block; text-align: left;">
          <li>JSP and custom tags</li>
          <li>Servlets and controllers</li>
          <li>Command pattern for flow control</li>
          <li>Value objects for data transfer</li>
          <li>Template system for consistent layout</li>
        </ul>
      </div>
    </div>
  </template:put>
</template:insert>
