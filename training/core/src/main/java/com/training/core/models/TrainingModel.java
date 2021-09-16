package com.training.core.models;

import com.training.core.config.OSGiConfigModule;
import com.training.core.config.TrainingOSGiConfig;
import com.training.core.config.TrainingOSGiConfigModule;
import com.training.core.services.DemoService;
import com.training.core.services.DemoServiceB;
import com.training.core.services.MultiService;
import com.training.core.services.MultiServiceConsumerService;
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

    @OSGiService
    DemoService demoService;

    @OSGiService
    DemoServiceB demoServiceB;

    @OSGiService(filter = "(component.name=serviceA)")
    MultiService  multiServiceA;

    @OSGiService(filter = "(component.name=serviceB)")
    MultiService  multiServiceB;

    @OSGiService
    MultiServiceConsumerService multiServiceConsumerService;

    public String getMultiServiceConsumerServiceA(){
        return multiServiceConsumerService.getNameFromServiceA();
    }


    public String getMultiServiceConsumerServiceB(){
        return multiServiceConsumerService.getNameFromServiceB();
    }


    public String getNameFromMultiAService(){
        return multiServiceA.getName();
    }

    public String getNameFromMultiBService(){
        return multiServiceB.getName();
    }

    public String getServiceName(){
        logger.info("Service Name:"+trainingOSGiConfig.getServiceName());
        return trainingOSGiConfig.getServiceName();
    }
    public String getMessage(){
        return demoService.greeting();
    }

    public String getDemoMessage(){
        return demoServiceB.getDemoServiceBMessage();
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
