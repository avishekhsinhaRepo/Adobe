package com.training.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Custom Factory Configuration",description ="Custom Factory Configuration")
public @interface CustomFactoryConfig {
    @AttributeDefinition(name = "Service Name",description = "Service Name",type = AttributeType.STRING)
    public String serviceName();
    @AttributeDefinition(name = "Service URL",description = "Service URL",type = AttributeType.STRING)
    public String serviceURL();

}
