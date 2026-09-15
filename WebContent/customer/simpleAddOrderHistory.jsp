<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Order History</title>
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
                <li><a href="<%=request.getContextPath()%>/index.html">Home</a></li>
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
        <a href="<%=request.getContextPath()%>/index.html">Home</a> &gt;
        <a href="<%=request.getContextPath()%>/customer/simpleCustomerView.jsp">Customer Management</a> &gt;
        <a href="<%=request.getContextPath()%>/customer/simpleOrderHistory.jsp">Order History</a> &gt;
        Add Entry
    </div>

    <div id="content">
        <h1>Add Order History Entry</h1>

        <form action="<%=request.getContextPath()%>/customer/simpleOrderHistory.jsp" method="post">
            <table width='100%' border='0' cellspacing='0' cellpadding='0'>
                <tr><td class='listsubhead' colspan='2'>ORDER HISTORY INFORMATION</td></tr>

                <!-- Order date field -->
                <tr>
                    <td class='label' width='20%'>Order Date:</td>
                    <td class='field'>
                        <input type='text' name='orderDate' value='<%= new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date()) %>' size='10' maxlength='10'>
                        <span class='required'>*</span>
                    </td>
                </tr>

                <!-- Representative field -->
                <tr>
                    <td class='label'>Representative:</td>
                    <td class='field'>
                        <input type='text' name='representative' value='' size='30' maxlength='50'>
                        <span class='required'>*</span>
                    </td>
                </tr>

                <!-- Order type field -->
                <tr>
                    <td class='label'>Order Type:</td>
                    <td class='field'>
                        <select name='orderTypeId'>
                            <option value=''>-- Select Order Type --</option>
                            <option value='1'>New Order</option>
                            <option value='2'>Order Update</option>
                            <option value='3'>Order Cancellation</option>
                            <option value='4'>Return/Refund</option>
                            <option value='5'>Shipping Inquiry</option>
                        </select>
                        <span class='required'>*</span>
                    </td>
                </tr>

                <!-- Note field -->
                <tr>
                    <td class='label'>Note:</td>
                    <td class='field'>
                        <textarea name='note' rows='5' cols='50'></textarea>
                        <span class='required'>*</span>
                    </td>
                </tr>

                <!-- Order number field -->
                <tr>
                    <td class='label'>Order Number:</td>
                    <td class='field'>
                        <input type='text' name='orderNumber' value='' size='20' maxlength='20'>
                    </td>
                </tr>
            </table>

            <br>
            <table class="buttons" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td><input type="submit" value="Save" class="button"></td>
                    <td><input type="button" value="Cancel" onclick="window.location.href='<%=request.getContextPath()%>/customer/simpleOrderHistory.jsp';" class="button"></td>
                </tr>
            </table>
        </form>
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
