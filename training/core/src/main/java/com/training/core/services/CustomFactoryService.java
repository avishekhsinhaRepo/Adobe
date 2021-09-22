package com.training.core.services;

import com.training.core.config.CustomFactoryConfig;

import java.util.List;

public interface CustomFactoryService {
    public String getServiceName();
    public String getServiceURL();
    public List<CustomFactoryService> getCustomOSGIConfigurations();
}
