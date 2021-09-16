package com.training.core.services.impl;

import com.training.core.config.TrainingOSGiFactoryConfig;
import com.training.core.services.OSGiFactoryConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service = OSGiFactoryConfig.class)
@Designate(ocd = TrainingOSGiFactoryConfig.class,factory = true)
public class OSGiFactoryConfigImpl implements OSGiFactoryConfig {

    private int configId;

    private String serviceName;

    private String serviceUrl;

    @Activate
    protected void activate(TrainingOSGiFactoryConfig trainingOSGiFactoryConfig){

    }

    @Deactivate
    protected void deActivate(TrainingOSGiFactoryConfig trainingOSGiFactoryConfig){

    }

    @Override
    public int getConfigID() {
        return 0;
    }

    @Override
    public String getServiceName() {
        return null;
    }

    @Override
    public String getServiceURL() {
        return null;
    }

    @Override
    public OSGiFactoryConfig get(int configID) {
        return null;
    }

    @Override
    public List<OSGiFactoryConfig> getAllConfigs() {
        return null;
    }
}
