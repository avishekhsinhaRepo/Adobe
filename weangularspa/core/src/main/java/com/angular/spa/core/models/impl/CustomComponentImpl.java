package com.angular.spa.core.models.impl;

import com.angular.spa.core.models.CustomComponent;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;


@Model(adapters = SlingHttpServletRequest.class,  adaptables = { CustomComponent.class,
    ComponentExporter.class }, resourceType = CustomComponentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CustomComponentImpl implements CustomComponent {

    static final String RESOURCE_TYPE = "weangularspa/components/custom-component";

    @ValueMapValue
    private String message;

    @Override
    public String getMessage() {
        return StringUtils.isNotBlank(message) ? message.toUpperCase() : "";
    }

    @Override
    public String getExportedType() {
        return CustomComponentImpl.RESOURCE_TYPE;
    }

}