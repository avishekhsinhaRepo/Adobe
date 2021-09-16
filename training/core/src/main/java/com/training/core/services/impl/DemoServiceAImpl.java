package com.training.core.services.impl;

import com.training.core.services.DemoService;
import org.osgi.service.component.annotations.Component;

@Component(service = DemoService.class,immediate = true)
public class DemoServiceAImpl implements DemoService {
    @Override
    public String greeting() {
        return "Hello World!";
    }
}
