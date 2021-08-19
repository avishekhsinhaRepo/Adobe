package com.aem.geeks.core.models.impl;


import com.aem.geeks.core.models.Employee;

import com.aem.geeks.core.services.ChildPagesService;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;
import java.util.Iterator;

@Model(adaptables = Resource.class,
        adapters = Employee.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeImpl implements Employee {

    @Inject
    @Default(values = "AEM")
    String fname;

    @Inject
    @Required
    @Default(values = "Geeks")
    String lname;

    @Inject
    boolean permanent;

    @OSGiService
    ChildPagesService childPagesService;

    @Self
    Resource resource;

    @Override
    public String getFirstName() {
        return fname.concat(resource.getPath());
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsPermanent() {
        return permanent;
    }

    @Override
    public Iterator<Page> getPages() {
        return childPagesService.getPages();
    }
}
