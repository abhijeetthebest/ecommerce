# E-commerce Web Application

This is a demonstration of an e-commerce web application using JSP, servlets, flows, taglibs, commands, and value objects.

## Project Structure

The project follows a standard Java web application structure:

```
EcommerceWeb/
├── WebContent/          # Web resources
│   ├── WEB-INF/         # Configuration files
│   │   ├── tlds/        # Tag Library Descriptors
│   │   ├── web.xml      # Web Application Descriptor
│   │   └── lib/         # JAR dependencies
│   ├── css/             # Stylesheets
│   ├── js/              # JavaScript files
│   ├── images/          # Image files
│   ├── customer/        # Customer management JSPs
│   ├── catalog/         # Catalog management JSPs
│   ├── order/           # Order management JSPs
│   └── *.jsp            # JSP pages
├── src/                 # Java source code
│   └── com/ecommerce/   # Java packages
│       ├── presentation/ # Presentation layer
│       │   ├── flow/    # Flow controllers
│       │   ├── command/ # Command pattern
│       │   ├── tag/     # Custom tags
│       │   └── servlet/ # Servlets
│       ├── business/    # Business layer
│       ├── data/        # Data access layer
│       └── view/        # Value objects
└── config/              # Configuration files
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6 or higher

## Compiling the Application

To compile the application, run the following command in the project root directory:

```bash
cd EcommerceWeb
mvn clean package
```

This will create a WAR file in the `target` directory.

## Running the Application

You can run the application using the Maven Tomcat plugin:

```bash
cd EcommerceWeb
mvn tomcat7:run
```

This will start a Tomcat server on port 9090 and deploy the application. You can access it at http://localhost:9090/ecommerce

## Accessing the Application

### Using a Web Browser

Start by accessing the home page, which provides navigation to all working parts of the application:

```
http://localhost:9090/ecommerce/index.html
```

From the home page, you'll see three main sections:

1. **Working Pages** (Green Buttons) - These are fully functional:
   - **Customer View**: Access the customer management page
   - **Order History**: View and manage order history entries
   - **Add Order History**: Create new order history entries

2. **Original Functions** (May Not Work) - These use the controller servlet which has template rendering issues

3. **Test Pages** - Simple pages for testing basic functionality

### Direct URLs

You can also access the working pages directly using these URLs:

1. **Home Page**: http://localhost:9090/ecommerce/index.html
2. **Customer View**: http://localhost:9090/ecommerce/customer/simpleCustomerView.jsp
3. **Order History**: http://localhost:9090/ecommerce/customer/simpleOrderHistory.jsp
4. **Add Order History**: http://localhost:9090/ecommerce/customer/simpleAddOrderHistory.jsp
5. **Test JSP Page**: http://localhost:9090/ecommerce/test.jsp

### Navigation Flow

The application supports the following navigation flow:

1. **Home Page** → Click any green button in the "Working Pages" section
2. **Customer View** → Click "add order history" or "maintain order history" links
3. **Order History** → Click "add order history" or "RETURN to customer" links
4. **Add Order History** → Click "Save" or "Cancel" buttons

### Using Curl Commands

You can also access the application using curl commands:

```bash
# Access the home page
curl -v http://localhost:9090/ecommerce/index.html

# Access the test JSP page
curl -v http://localhost:9090/ecommerce/test.jsp

# Access the customer view page
curl -v http://localhost:9090/ecommerce/customer/simpleCustomerView.jsp

# Access the order history page
curl -v http://localhost:9090/ecommerce/customer/simpleOrderHistory.jsp

# Access the add order history page
curl -v http://localhost:9090/ecommerce/customer/simpleAddOrderHistory.jsp
```

**Note**: The controller servlet is implemented but has issues with template rendering. For the best experience, use the simplified JSP pages accessible via the green buttons on the home page.

## Features

- **Customer Management**
  - View and update customer information
  - Manage order history
  - Track customer preferences

- **Catalog Management**
  - Manage product catalog
  - Organize products into categories
  - Set pricing and inventory

- **Order Management**
  - Create and process orders
  - Track order status
  - Handle returns and refunds

## Architecture

The application follows a command pattern architecture:

1. **Presentation Layer**
   - JSP pages for the user interface
   - Custom tags for reusable UI components
   - Template system for consistent layout

2. **Controller Layer**
   - Servlets for handling HTTP requests
   - Flow controllers for navigation
   - Command pattern for business operations

3. **Business Layer**
   - Business delegates for service access
   - Value objects for data transfer

4. **Data Layer**
   - Data access objects for database operations
   - Mock implementations for demonstration

## Working Components

### Fully Functional Components

These components are accessible via the green buttons on the home page:

#### JSP Pages

- **index.html**: Redesigned home page with clear navigation to working components
- **customer/simpleCustomerView.jsp**: Customer management page
- **customer/simpleOrderHistory.jsp**: Order history management page
- **customer/simpleAddOrderHistory.jsp**: Add order history entry page
- **test.jsp**: Simple JSP page for testing
- **hello.html**: Simple HTML page for testing

### Implemented But May Have Issues

These components are implemented but have issues with template rendering:

#### Controller and Flow Components

- **ControllerServlet**: Main controller servlet that handles all requests
- **CommandPatternFlowController**: Implements the command pattern for flow control
- **Flow Command Executors**: Handle specific flows (Customer, Catalog, Order)
- **Commands**: Implement business operations (DisplayCustomerSummary, OrderHistoryAdd, etc.)
- **Value Objects**: Transfer data between layers (CustomerSummaryVO, OrderHistoryVO, etc.)

**Important Finding**: We've identified that the specific issue is with the template rendering system used in JSP files:

- **Working**: http://localhost:9090/ecommerce/index.html (HTML file)
- **Not Working**: http://localhost:9090/ecommerce/index.jsp (JSP file with template tags)

This confirms that while all components are implemented according to the requested architecture (JSP, servlets, flows, taglibs, commands, and value objects), there are issues specifically with the template tag rendering system. For the best experience, use the HTML files and simplified JSP pages accessible via the green buttons on the home page.

## Troubleshooting

1. **Template Tag Issues**:
   - The application includes both template-based JSPs and simplified JSPs
   - We've identified that JSP files using template tags (like index.jsp) don't render correctly
   - HTML files (like index.html) and simplified JSP files (without template tags) work correctly
   - For the best experience, use the green buttons on the home page to access the working pages

2. **Port Conflict**: If port 9090 is already in use, you can change the port in the pom.xml file:

```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <port>9090</port> <!-- Change this to another port -->
        <path>/ecommerce</path>
    </configuration>
</plugin>
```

3. **Controller Servlet Issues**:
   - The controller servlet is implemented but has issues with template rendering
   - URLs like http://localhost:9090/ecommerce/control?flow=CustomerMaintenance&flowAction=DisplayCustomerSummary&customerId=123 may not work correctly
   - Use the direct URLs to the simplified JSP pages instead

## Notes

This is a demonstration application with mock data. In a production environment, you would need to:

1. Configure a real database
2. Implement proper security measures
3. Add error handling and logging
4. Optimize performance
5. Add unit and integration tests
