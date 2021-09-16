package com.training.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Training Factory Configuration",description = "Training Factory Configuration")
public @interface TrainingOSGiFactoryConfig {

    @AttributeDefinition(name = "Config Id",type = AttributeType.INTEGER,description = "Service Configuration Id")
    int configId() ;

    @AttributeDefinition(name = "Service Id",type = AttributeType.STRING,description = "Service Id")
    public String serviceName() default "Service Id #";

    @AttributeDefinition(name = "Service Url",type = AttributeType.STRING,description = "Service URL")
    public String serviceUrl() default "Service Url #";

}
