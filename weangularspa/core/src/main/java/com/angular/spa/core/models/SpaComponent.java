package com.angular.spa.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface SpaComponent extends ComponentExporter {

    public String getTitle();

    public boolean getEnableTitle();
}
