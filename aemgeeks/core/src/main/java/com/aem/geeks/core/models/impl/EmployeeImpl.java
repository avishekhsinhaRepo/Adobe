package com.aem.geeks.core.models.impl;


import com.aem.geeks.core.services.ChildPagesService;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import com.aem.geeks.core.models.Employee;

import javax.inject.Inject;
import java.util.Iterator;

@Model(adaptables = Resource.class,
        adapters = Employee.class,
        resourceType = "aemgeeks/components/content/employee",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", selector = "geeks",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
                @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        })
@JsonRootName(value = "employeeData")
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
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsPermanent() {
        return permanent;
    }

    @JsonProperty(value = "company")
    public String companyName() {
        return "COMPANY INC";
    }


    @JsonIgnore
    public String getAddress() {
        return "202 Eden Park";
    }


    @Override
    @JsonProperty(value = "pageList")
    public Iterator<Page> getPages() {
        return childPagesService.getPages();
    }
}
