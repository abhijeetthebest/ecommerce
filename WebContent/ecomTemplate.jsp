<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>
<%@ taglib uri='/WEB-INF/tlds/ecom.tld' prefix='ecom' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><template:get name='title'/></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ecom.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ecom.js"></script>
</head>
<body>
    <div id="header">
        <div id="logo">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="E-commerce Logo">
        </div>
        <div id="navigation">
            <ul>
                <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/catalog/browseCatalog.jsp">Products</a></li>
                <li><a href="<%=request.getContextPath()%>/order/viewCart.jsp">Cart</a></li>
                <li><a href="<%=request.getContextPath()%>/customer/myAccount.jsp">My Account</a></li>
                <li><a href="<%=request.getContextPath()%>/customer/customerService.jsp">Customer Service</a></li>
            </ul>
        </div>
        <div id="search">
            <form action="<%=request.getContextPath()%>/control" method="post">
                <input type="hidden" name="flow" value="CatalogSearch">
                <input type="hidden" name="flowAction" value="SearchProducts">
                <input type="text" name="searchTerm" placeholder="Search products...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    
    <div id="breadcrumb">
        <template:get name='navList'/>
    </div>
    
    <div id="content">
        <template:get name='content'/>
    </div>
    
    <div id="footer">
        <div id="footerLinks">
            <ul>
                <li><a href="<%=request.getContextPath()%>/about.jsp">About Us</a></li>
                <li><a href="<%=request.getContextPath()%>/contact.jsp">Contact Us</a></li>
                <li><a href="<%=request.getContextPath()%>/terms.jsp">Terms & Conditions</a></li>
                <li><a href="<%=request.getContextPath()%>/privacy.jsp">Privacy Policy</a></li>
            </ul>
        </div>
        <div id="copyright">
            &copy; 2023 E-commerce Company. All rights reserved.
        </div>
    </div>
</body>
</html>
