package com.training.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Training Scheduler OSGI Config",description = "Training Scheduler OSGI Config")
public @interface TrainingSchedulerOSGiConfig {
    @AttributeDefinition(name = "Scheduler Name",description = "Scheduler Name",type = AttributeType.STRING)
    public String scheduleName() default "Training Scheduler Name";

    @AttributeDefinition(name = "Scheduler Name",description = "Scheduler Name",type = AttributeType.STRING)
    public String cronExpression() default "0/20 * * * * ?"; // runs every 10 seconds
}
