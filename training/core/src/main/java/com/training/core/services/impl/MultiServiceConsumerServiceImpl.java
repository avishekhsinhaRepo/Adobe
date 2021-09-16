package com.training.core.services.impl;

import com.training.core.services.MultiService;
import com.training.core.services.MultiServiceConsumerService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = MultiServiceConsumerService.class,immediate = true)
public class MultiServiceConsumerServiceImpl implements MultiServiceConsumerService {

    @Reference(target = "(component.name=serviceA)")
    private MultiService multiServiceA;
    @Reference(target ="(component.name=serviceB)")
    private MultiService multiServiceB;

    @Override
    public String getNameFromServiceA() {
        return multiServiceA.getName();
    }

    @Override
    public String getNameFromServiceB() {
        return multiServiceB.getName();
    }
}
