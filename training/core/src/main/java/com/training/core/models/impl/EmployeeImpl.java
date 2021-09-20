package com.training.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.training.core.models.Employee;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,adapters = Employee.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeImpl implements Employee {

    @Inject
    @Default(values = "AEM")
    @Via("resource")
    private String fname;

    @ValueMapValue
    @Default(values = "DEV")
    private String lname;

    @Inject
    @Via("resource")
    private boolean isPermanent;

    @ScriptVariable
    @Default(values = "NO_TITLE")
    private Page currentPage;

    @SlingObject
    ResourceResolver resourceResolver;

    @Inject
    @Via("resource")
    @Named("jcr:primaryType")
    String primaryType;

    @RequestAttribute(name = "companyName")
     private String rAttribute;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @ResourcePath(path = "/content/training/us/en/homepage")
    @Via("resource")
    Resource homePageResource;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean isPermanent() {
        return isPermanent;
    }

    @Override
    public String getFullName() {
        return fname+ " "+lname;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getPageTitle();
    }

    @Override
    public String getResourcePrimaryType() {
        return primaryType;
    }

    @Override
    public String getRequestAttribute() {
        return rAttribute;
    }

    @Override
    public String getHomePageName() {
        return homePageResource.getName();
    }
}
