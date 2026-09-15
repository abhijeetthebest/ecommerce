/**
 * Submit a form.
 * 
 * @param form The form to submit
 */
function go(form) {
    if (form) {
        form.submit();
    }
}

/**
 * Cancel an action.
 * 
 * @param flow The flow
 * @param flowAction The flow action
 */
function cancelAction(flow, flowAction) {
    var form = document.createElement('form');
    form.method = 'post';
    form.action = 'control';
    
    var flowInput = document.createElement('input');
    flowInput.type = 'hidden';
    flowInput.name = 'flow';
    flowInput.value = flow;
    form.appendChild(flowInput);
    
    var flowActionInput = document.createElement('input');
    flowActionInput.type = 'hidden';
    flowActionInput.name = 'flowAction';
    flowActionInput.value = flowAction;
    form.appendChild(flowActionInput);
    
    document.body.appendChild(form);
    form.submit();
}

/**
 * Open a child window.
 * 
 * @param url The URL to open
 */
function openChildWindow(url) {
    window.open(url, 'childWindow', 'width=800,height=600,resizable=yes,scrollbars=yes');
}

/**
 * Open a data point.
 * 
 * @param url The URL to open
 */
function dataPoint(url) {
    window.open(url, 'dataPoint', 'width=800,height=600,resizable=yes,scrollbars=yes');
}

/**
 * Send an email.
 * 
 * @param url The URL to open
 */
function sendEmail(url) {
    window.open(url, 'emailWindow', 'width=800,height=600,resizable=yes,scrollbars=yes');
}

/**
 * Perform a customer action.
 * 
 * @param actionName The action name
 */
function performCustomerAction(actionName) {
    document.customerSummaryForm.flowAction.value = actionName;
    go(document.customerSummaryForm);
}

/**
 * Perform an order history action.
 * 
 * @param actionName The action name
 */
function performOrderHistoryAction(actionName) {
    document.resultsForm2.flowAction.value = actionName;
    go(document.resultsForm2);
}

/**
 * Search customer email.
 * 
 * @param associationType The association type
 * @param applicationId The application ID
 */
function searchCustomerEmail(associationType, applicationId) {
    document.searchEmailHistoryForm.associationType.value = associationType;
    document.searchEmailHistoryForm.applicationId.value = applicationId;
    document.searchEmailHistoryForm.customerId.value = document.customerSummaryForm.customerId.value;
    go(document.searchEmailHistoryForm);
}

/**
 * Edit order history.
 * 
 * @param orderHistoryId The order history ID
 */
function editOrderHistory(orderHistoryId) {
    document.resultsForm2.orderHistoryId.value = orderHistoryId;
    document.resultsForm2.flowAction.value = "OrderHistoryEdit";
    go(document.resultsForm2);
}
