package com.training.core.config.impl;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.training.core.config.TrainingOSGiConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;

@Component(service = TrainingOSGiConfig.class,immediate = true)
@Designate(ocd = TrainingOSGiConfigImpl.ServiceConfig.class)
public class TrainingOSGiConfigImpl implements TrainingOSGiConfig {

    @ObjectClassDefinition(name = "Training- OSGi Configuration",description = "Training- OSGi Configuration")
    public @interface ServiceConfig{
        @AttributeDefinition(name = "Service Name",
                            description = "Name of Service",type = AttributeType.STRING)
        public String trainingServiceName() default "Training Service";

        @AttributeDefinition(name = "Service Count", description = "Service Count", type = AttributeType.INTEGER)
        public int  serviceCount() default 5;

        @AttributeDefinition(name = "is Live Data",type = AttributeType.BOOLEAN, description = "is Live Data")
        public boolean isLiveData() default false;

        @AttributeDefinition(name = "Countries", type = AttributeType.STRING, description = "Add Country")
        String[] countries() default {"de", "in"};

        @AttributeDefinition(name="Run Mode", description = "Select Run Mode",options = {
                @Option(label = "Author", value = "author"),
                @Option(label = "Publish", value = "publish"),
                @Option(label = "Both", value = "both")
        })
        String runMode() default "both";
    }

    private String trainingServiceName;
    private int serviceCount;
    private boolean isLiveData;
    private String[] countries;
    private String runMode;

    @Activate
    public void activate(ServiceConfig serviceConfig){
        trainingServiceName = serviceConfig.trainingServiceName();
        isLiveData = serviceConfig.isLiveData();
        serviceCount = serviceConfig.serviceCount();
        countries = serviceConfig.countries();
        runMode = serviceConfig.runMode();

    }

    @Override
    public String getServiceName() {
        return trainingServiceName;
    }

    @Override
    public int getServiceCount() {
        return serviceCount;
    }

    @Override
    public boolean isLiveData() {
        return isLiveData;
    }

    @Override
    public String[] getCountries() {
        return countries;
    }

    @Override
    public String getRunModes() {
        return runMode;
    }
}
