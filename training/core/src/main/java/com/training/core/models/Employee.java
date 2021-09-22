package com.training.core.models;

import com.training.core.config.CustomFactoryConfig;
import com.training.core.services.CustomFactoryService;

import java.util.List;
import java.util.Map;

public interface Employee {
    public String getFirstName();
    public String getLastName();
    public boolean isPermanent();
    public String getFullName();
    public String getPageTitle();
    public String getResourcePrimaryType();
    public String getRequestAttribute();
    public String getHomePageName();
    public List<CustomFactoryService> getFactoryConfigs();
    public List<String> getEmployeeSkills();
    public List<Map<String,String>>getBooks();
}
