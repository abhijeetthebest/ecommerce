<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
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
        Order History
    </div>

    <div id="content">
        <table>
            <tr class="e">
                <td nowrap>MAINTAIN ORDER HISTORY</td>
                <td nowrap align="right">
                    [<a href="<%=request.getContextPath()%>/customer/simpleAddOrderHistory.jsp" class="linkonDark">add order history</a>]
                    [<a href="javascript:void(0);" class="linkonDark">view EXTERNAL order history</a>]
                    [<a href="<%=request.getContextPath()%>/customer/simpleCustomerView.jsp" class="linkonDark">RETURN to customer</a>]
                </td>
            </tr>
        </table>

        <!-- Results table for order history entries -->
        <table class="softresults">
            <tr class="listhead">
                <td>Date</td>
                <td>Representative</td>
                <td>Type</td>
                <td>Note</td>
                <td>Order Number</td>
                <td>Action</td>
            </tr>
            <tr class="tiny">
                <td>04/12/2025</td>
                <td>John Smith</td>
                <td>New Order</td>
                <td>Customer placed a new order for 3 items</td>
                <td>ORD123456</td>
                <td><a href="javascript:void(0);">Edit</a></td>
            </tr>
            <tr class="tiny">
                <td>04/10/2025</td>
                <td>Jane Doe</td>
                <td>Return/Refund</td>
                <td>Customer returned item due to damage</td>
                <td>ORD123457</td>
                <td><a href="javascript:void(0);">Edit</a></td>
            </tr>
        </table>
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
