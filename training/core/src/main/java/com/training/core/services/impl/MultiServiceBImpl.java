package com.training.core.services.impl;

import com.training.core.services.MultiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(service = MultiService.class,immediate = true, name = "serviceB")
@ServiceRanking(1001)
public class MultiServiceBImpl implements MultiService {
    @Override
    public String getName() {
        return "Message from : MultiServiceBImpl";
    }
}
