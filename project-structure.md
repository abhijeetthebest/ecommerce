# E-commerce Web Application Structure

## Directory Structure

```
EcommerceWeb/
├── WebContent/
│   ├── WEB-INF/
│   │   ├── tlds/           # Tag Library Descriptors
│   │   ├── web.xml         # Web Application Descriptor
│   │   └── lib/            # JAR dependencies
│   ├── ecomTemplate.jsp    # Main template
│   ├── error.jsp           # Error page
│   ├── catalog/            # Catalog related JSPs
│   │   ├── maintainCatalogItem.jsp
│   │   ├── catalogItemHeader.jsp
│   │   ├── catalogItemContent.jsp
│   │   └── ...
│   ├── customer/           # Customer related JSPs
│   │   ├── maintainCustomerInformation.jsp
│   │   ├── customerSummaryHeader.jsp
│   │   ├── customerSummaryContent.jsp
│   │   ├── addOrderHistory.jsp
│   │   ├── maintainOrderHistory.jsp
│   │   └── ...
│   ├── order/              # Order related JSPs
│   │   ├── createOrder.jsp
│   │   ├── orderSummary.jsp
│   │   └── ...
│   └── css/                # Stylesheets
│       └── ecom.css
├── src/
│   └── com/
│       └── ecommerce/
│           ├── presentation/
│           │   ├── flow/
│           │   │   ├── FlowController.java
│           │   │   ├── CommandPatternFlowController.java
│           │   │   └── ...
│           │   ├── command/
│           │   │   ├── AbstractCommand.java
│           │   │   ├── customer/
│           │   │   │   ├── DisplayCustomerSummaryCommand.java
│           │   │   │   ├── CustomerOrderHistoryAddCommand.java
│           │   │   │   └── ...
│           │   │   ├── catalog/
│           │   │   │   ├── DisplayCatalogItemCommand.java
│           │   │   │   └── ...
│           │   │   └── order/
│           │   │       ├── CreateOrderCommand.java
│           │   │       └── ...
│           │   └── tag/
│           │       ├── OrderHistoryTag.java
│           │       └── ...
│           ├── business/
│           │   ├── delegate/
│           │   │   ├── CustomerDelegate.java
│           │   │   ├── OrderHistoryDelegate.java
│           │   │   ├── CatalogDelegate.java
│           │   │   └── ...
│           │   └── service/
│           │       ├── CustomerService.java
│           │       ├── OrderHistoryService.java
│           │       ├── CatalogService.java
│           │       └── ...
│           ├── data/
│           │   ├── CustomerDAO.java
│           │   ├── OrderHistoryDAO.java
│           │   ├── CatalogDAO.java
│           │   └── ...
│           └── view/
│               ├── customer/
│               │   ├── CustomerSummaryVO.java
│               │   ├── OrderHistoryVO.java
│               │   └── ...
│               ├── catalog/
│               │   ├── CatalogItemVO.java
│               │   └── ...
│               └── order/
│                   ├── OrderVO.java
│                   └── ...
└── config/
    └── ecomFlow.xml        # Flow configuration
```

## Key Components

1. **Customer Management** - Similar to Household Management
   - Customer information
   - Order history (similar to Contact History)
   - Customer addresses
   - Payment methods

2. **Catalog Management** - Product catalog
   - Product information
   - Categories
   - Pricing
   - Inventory

3. **Order Management** - Order processing
   - Shopping cart
   - Order creation
   - Order status
   - Shipping

4. **Work Queue System** - For order fulfillment
   - Order processing tasks
   - Customer service tasks

5. **Flow Controller** - Command pattern implementation
   - Maps actions to commands
   - Handles navigation

6. **Value Objects** - Data transfer objects
   - CustomerSummaryVO
   - OrderHistoryVO
   - CatalogItemVO
   - OrderVO

7. **Custom Tags** - JSP tag libraries
   - OrderHistoryTag
   - ProductListTag
   - CustomerInfoTag
