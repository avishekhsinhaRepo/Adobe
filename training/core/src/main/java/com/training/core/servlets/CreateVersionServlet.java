package com.training.core.servlets;


import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
@Component(service = Servlet.class)
@SlingServletPaths(value ={ "/bin/createversion"})
public class CreateVersionServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String payload  = request.getParameter("path");
        ResourceResolver resourceResolver = request.getResourceResolver();
        WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
        try {
            WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/training-workflow");
            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH",payload);
            workflowSession.startWorkflow(workflowModel,workflowData);
        } catch (WorkflowException e) {
            e.printStackTrace();
        }

    }
}
