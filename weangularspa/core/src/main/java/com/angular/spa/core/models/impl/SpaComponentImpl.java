package com.angular.spa.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.angular.spa.core.models.SpaComponent;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adapters = SlingHttpServletRequest.class,adaptables = {ComponentExporter.class,SpaComponent.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = SpaComponentImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SpaComponentImpl implements SpaComponent {

    static final String RESOURCE_TYPE = "weangularspa/components/spacomp";
    @ValueMapValue
    private String title;
    @ValueMapValue
    private boolean enableTitle;
    @Override
    public String getExportedType() {
        return SpaComponentImpl.RESOURCE_TYPE;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean getEnableTitle() {
        return enableTitle;
    }
}
