package com.training.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Training - OSGI Config Module",description = "Training - OSGI Config Module")
public @interface OSGiConfigModule {

    @AttributeDefinition(name = "Service Name",description = "Name of Service",type = AttributeType.STRING)
    public String serviceName();

    @AttributeDefinition(name = "Service Count",description = "Count of Service",type = AttributeType.INTEGER)
    public int serviceCount();


    @AttributeDefinition(name = "Service Url",description = "URL of Service",type = AttributeType.STRING)
    public String serviceUrl();
}
