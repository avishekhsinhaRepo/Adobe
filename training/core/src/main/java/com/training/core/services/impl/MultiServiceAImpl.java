package com.training.core.services.impl;

import com.training.core.services.MultiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(service = MultiService.class,immediate = true, name = "serviceA")
@ServiceRanking(1000)
public class MultiServiceAImpl implements MultiService {
    @Override
    public String getName() {
        return "Message from : MultiServiceAImpl";
    }
}
