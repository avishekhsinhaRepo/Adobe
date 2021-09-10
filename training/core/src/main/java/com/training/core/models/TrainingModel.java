package com.training.core.models;

import com.training.core.config.OSGiConfigModule;
import com.training.core.config.TrainingOSGiConfig;
import com.training.core.config.TrainingOSGiConfigModule;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class)
public class TrainingModel {
    public static final Logger logger = LoggerFactory.getLogger(TrainingModel.class);
    @OSGiService
    TrainingOSGiConfig trainingOSGiConfig;

    @OSGiService
    TrainingOSGiConfigModule trainingOSGiConfigModule;

    public String getServiceName(){
        logger.info("Service Name:"+trainingOSGiConfig.getServiceName());
        return trainingOSGiConfig.getServiceName();
    }


    public int getServiceCount() {
        return trainingOSGiConfig.getServiceCount();
    }

    public boolean isLiveData() {
        return trainingOSGiConfig.isLiveData();
    }

    public String[] getCountries() {
        return trainingOSGiConfig.getCountries();
    }

    public String getRunModes() {
        return trainingOSGiConfig.getRunModes();
    }

    public String getServiceNameWithInterface(){
        return trainingOSGiConfigModule.getServiceName();
    }


    public int getServiceCountWithInterface() {
        return trainingOSGiConfigModule.getServiceCount();
    }

    public String getServiceUrlWithInterface() {
        return trainingOSGiConfigModule.getServiceUrl();
    }

}
