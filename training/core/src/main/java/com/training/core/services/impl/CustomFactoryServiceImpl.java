package com.training.core.services.impl;

import com.training.core.config.CustomFactoryConfig;
import com.training.core.services.CustomFactoryService;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

import java.util.ArrayList;
import java.util.List;

@Component(service = CustomFactoryService.class,immediate = true,configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = CustomFactoryConfig.class,factory = true)
public class CustomFactoryServiceImpl implements CustomFactoryService {

    private String serviceName;
    private String serviceURl;
    private List<CustomFactoryService> customFactoryConfigList;

    @Activate
    @Modified
    protected void activate(CustomFactoryConfig customFactoryConfig){
        serviceName = customFactoryConfig.serviceName();
        serviceURl =customFactoryConfig.serviceURL();
    }
    @Reference(service = CustomFactoryService.class,cardinality = ReferenceCardinality.MULTIPLE,policy = ReferencePolicy.DYNAMIC)
    public void bindCustomOSGiConfiguration(CustomFactoryService customFactoryConfig){
        System.out.println("customFactoryConfigList="+ customFactoryConfigList);
        if(null== customFactoryConfigList)
            customFactoryConfigList = new ArrayList<>();
        customFactoryConfigList.add(customFactoryConfig);
    }

    public void unbindCustomOSGiConfiguration(CustomFactoryService customFactoryConfig){
        customFactoryConfigList.remove(customFactoryConfig);
    }


    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String getServiceURL() {
        return serviceURl;
    }

    @Override
    public List<CustomFactoryService> getCustomOSGIConfigurations() {
        return customFactoryConfigList;
    }
}
