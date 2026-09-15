<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Management</title>
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
        <a href="<%=request.getContextPath()%>/index.html">Home</a> &gt; Customer Management
    </div>

    <div id="content">
        <h1>Customer Management</h1>

        <table border="0" cellspacing="0" cellpadding="0">
            <tr class="e">
                <td>CUSTOMER SUMMARY</td>
                <td align="right">
                    [<a href="javascript:void(0);" class="linkonDark">view address history</a>]
                    [<a href="javascript:void(0);" class="linkOnDark">product recommendations</a>]
                    [<a href="javascript:void(0);" class="linkOnDark">send email</a>]
                    [<a href="javascript:void(0);" class="linkOnDark">email history</a>]
                </td>
            </tr>
        </table>

        <table border="0" cellspacing="0" cellpadding="0">
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
                <td valign=top nowrap>#CUST123 John Doe</td>
                <td valign=top nowrap>01/01/1980<br>43<br><b>01/01/2020</b><br>English</td>

                <td valign=top nowrap>
                    123 Main St<br>
                    Anytown, CA 12345
                </td>

                <td valign=top nowrap>
                    123 Main St<br>
                    Anytown, CA 12345
                </td>

                <td valign=top nowrap>
                    123 Main St<br>
                    Anytown, CA 12345
                </td>

                <td valign=top nowrap>
                    555-123-4567<br>
                    555-123-4567<br>
                    555-987-6543<br>
                    john.doe@example.com
                </td>

                <td valign=top nowrap>
                    Business to Consumer
                </td>

                <td valign=top nowrap>
                    Gold
                </td>

                <td valign=top nowrap>
                    Y
                </td>
            </tr>
        </table>

        <!-- Profile Summary Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>PROFILE SUMMARY</td>
                <td class="listsubhead" nowrap align="right">[<a href="javascript:void(0);" class="linkondark">update profile</a>]</td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO PROFILE EXISTS</td>
            </tr>
        </table>

        <!-- Active Preferences Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>ACTIVE PREFERENCES</td>
                <td class="listsubhead" nowrap align="right">[<a href="javascript:void(0);" class="linkondark">maintain preferences</a>]</td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO PREFERENCES EXIST</td>
            </tr>
        </table>

        <!-- Order History Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>ORDER HISTORY SUMMARY</td>
                <td class="listsubhead" nowrap align="right">
                    [<a href="<%=request.getContextPath()%>/customer/simpleAddOrderHistory.jsp" class="linkonDark">add order history</a>]
                    [<a href="<%=request.getContextPath()%>/customer/simpleOrderHistory.jsp" class="linkonDark">maintain order history</a>]
                    [<a href="javascript:void(0);" class="linkonDark">create work queue item</a>]
                    [<a href="javascript:void(0);" class="linkonDark">view customer interaction</a>]
                </td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO ORDER HISTORY</td>
            </tr>
        </table>

        <!-- Payment Methods Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>PAYMENT METHODS</td>
                <td class="listsubhead" nowrap align="right">
                    [<a href="javascript:void(0);" class="linkonDark">add payment method</a>]
                    [<a href="javascript:void(0);" class="linkonDark">maintain payment methods</a>]
                </td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO PAYMENT METHODS</td>
            </tr>
        </table>

        <!-- Order Summary Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>ORDER SUMMARY</td>
                <td class="listsubhead" nowrap align="right">
                    [<a href="javascript:void(0);" class="linkonDark">create new order</a>]
                </td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO ORDERS</td>
            </tr>
        </table>

        <!-- Wishlist Summary Section -->
        <table width='100%' border="0" cellspacing="0" cellpadding="1">
            <tr>
                <td class="listsubhead" nowrap>WISHLIST SUMMARY</td>
                <td class="listsubhead" nowrap align="right">
                    [<a href="javascript:void(0);" class="linkonDark">view wishlist</a>]
                </td>
            </tr>
        </table>
        <table class="softresults" border="0" cellspacing="0" cellpadding="0">
            <tr class="tiny">
                <td colspan="3">NO WISHLIST ITEMS</td>
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
