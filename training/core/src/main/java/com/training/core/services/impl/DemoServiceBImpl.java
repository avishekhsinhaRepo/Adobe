package com.training.core.services.impl;

import com.training.core.services.DemoService;
import com.training.core.services.DemoServiceB;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = DemoServiceB.class,immediate = true)
public class DemoServiceBImpl implements DemoServiceB {

    @Reference
    DemoService demoService;

    @Override
    public String getDemoServiceBMessage() {
        return "getDemoServiceBMessage"+ demoService.greeting();
    }
}
