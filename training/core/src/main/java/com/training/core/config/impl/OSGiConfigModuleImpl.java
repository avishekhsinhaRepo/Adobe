package com.training.core.config.impl;

import com.training.core.config.OSGiConfigModule;
import com.training.core.config.TrainingOSGiConfigModule;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(immediate = true,name = "Training - OSGI Configuration In Interface")
@Designate(ocd = OSGiConfigModule.class)
public class OSGiConfigModuleImpl implements TrainingOSGiConfigModule {
        private String serviceName;
        private int serviceCount;
        private String serviceUrl;

        @Activate
        public void activate(OSGiConfigModule osGiConfigModule){
            serviceName = osGiConfigModule.serviceName();
            serviceCount = osGiConfigModule.serviceCount();
            serviceUrl= osGiConfigModule.serviceUrl();
        }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public int getServiceCount() {
        return serviceCount;
    }


}
