package com.training.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletPaths(value = {
        "/bin/training",
        "/bin/training1"
})
@ServiceDescription("Path Based Servlet")
public class TrainingServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        JSONObject pageTitleJson =null;
        JSONArray pageArr = new JSONArray();
        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page  page = resourceResolver.adaptTo(PageManager.class).getPage("/content/training/us/en");
        Iterator<Page> children = page.listChildren();
        while (children.hasNext()){
            Page childPage = children.next();
            try {
                pageTitleJson = new JSONObject();
                pageTitleJson.put(childPage.getName(),childPage.getTitle());
                pageArr.put(pageTitleJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().write(String.valueOf(pageArr));
    }
}
