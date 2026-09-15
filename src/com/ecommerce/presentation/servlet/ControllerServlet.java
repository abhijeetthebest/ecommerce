package com.ecommerce.presentation.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ecommerce.presentation.context.ExternalContext;
import com.ecommerce.presentation.context.WindowContext;
import com.ecommerce.presentation.context.impl.ExternalContextImpl;
import com.ecommerce.presentation.context.impl.WindowContextImpl;
import com.ecommerce.presentation.constants.WebConstants;
import com.ecommerce.presentation.flow.FlowController;
import com.ecommerce.presentation.flow.FlowCommandExecutor;
import com.ecommerce.presentation.flow.FlowException;
import com.ecommerce.presentation.flow.FlowInstruction;
import com.ecommerce.presentation.flow.FlowLocator;
import com.ecommerce.presentation.flow.CommandPatternFlowController;
import com.ecommerce.presentation.util.Logger;

/**
 * Controller servlet for handling all requests.
 */
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FlowController flowController;

    /**
     * Initialize the servlet.
     *
     * @param config The servlet configuration
     * @throws ServletException If an error occurs during initialization
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Initialize the flow controller
        flowController = new CommandPatternFlowController();

        // For simplicity, we'll use a simple map for flow command executors
        // In a real application, this would be loaded from configuration
        Map<String, FlowCommandExecutor> executorMap = new HashMap<>();
        executorMap.put("CustomerMaintenance", new com.ecommerce.presentation.flow.impl.CustomerMaintenanceFlowCommandExecutor());
        executorMap.put("CatalogManagement", new com.ecommerce.presentation.flow.impl.CatalogManagementFlowCommandExecutor());
        executorMap.put("OrderManagement", new com.ecommerce.presentation.flow.impl.OrderManagementFlowCommandExecutor());

        // Set the executor map
        ((CommandPatternFlowController) flowController).setExecutorMap(executorMap);

        Logger.log(Logger.INFO, this.getClass().getName(), "init", "ControllerServlet initialized");
    }

    /**
     * Handle HTTP GET requests.
     *
     * @param request The HTTP servlet request
     * @param response The HTTP servlet response
     * @throws ServletException If an error occurs during processing
     * @throws IOException If an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handle HTTP POST requests.
     *
     * @param request The HTTP servlet request
     * @param response The HTTP servlet response
     * @throws ServletException If an error occurs during processing
     * @throws IOException If an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Process the request.
     *
     * @param request The HTTP servlet request
     * @param response The HTTP servlet response
     * @throws ServletException If an error occurs during processing
     * @throws IOException If an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get flow ID and action from request
            String flowId = request.getParameter("flow");
            String flowAction = request.getParameter("flowAction");

            if (flowId == null || flowAction == null) {
                // Default to home page
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

            // Create flow locator
            FlowLocator locator = new FlowLocator(flowId, flowAction);

            // Create external context
            ExternalContext externalContext = new ExternalContextImpl(request);

            // Create window context
            WindowContext windowContext = new WindowContextImpl();

            // Store window context in request
            request.setAttribute(WebConstants.WIN_CONTEXT_ID, windowContext);

            // Execute flow
            FlowInstruction instruction = flowController.execute(locator, externalContext);

            // Handle navigation
            if (instruction.isRedirect()) {
                response.sendRedirect(request.getContextPath() + instruction.getViewName());
            } else {
                request.getRequestDispatcher(instruction.getViewName()).forward(request, response);
            }
        } catch (FlowException e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "processRequest",
                    "Error processing request: " + e.getMessage());
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.log(Logger.ERROR, this.getClass().getName(), "processRequest",
                    "Unexpected error: " + e.getMessage());
            request.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
