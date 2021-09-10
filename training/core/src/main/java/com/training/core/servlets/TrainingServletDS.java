package com.training.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
            ServletResolverConstants.SLING_SERVLET_METHODS +"="+ HttpConstants.METHOD_GET,
            ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES +"="+ "training/components/page",
            ServletResolverConstants.SLING_SERVLET_SELECTORS +"="+"ds",
            ServletResolverConstants.SLING_SERVLET_EXTENSIONS +"="+"xml"
    })
public class TrainingServletDS  extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Resource resource = request.getResource();
        String  title = resource.getValueMap().get(JcrConstants.JCR_TITLE, StringUtils.EMPTY);
        System.out.println("Title is ="+title);
        response.getWriter().println(title);
    }
}
