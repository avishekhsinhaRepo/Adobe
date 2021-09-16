package com.training.core.listeners;

import com.training.core.utils.ResourceResolverUtils;
import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

@Component(service = EventHandler.class,immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED",
                EventConstants.EVENT_FILTER +"=/content/training"
})
public class  OSGiEventHandler implements EventHandler {

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(Event event) {
        try {
            ResourceResolver resourceResolver = ResourceResolverUtils.newResourceResolver(resourceResolverFactory);
            Resource resource = resourceResolver.getResource(event.getProperty(SlingConstants.PROPERTY_PATH).toString());
            Node node = resource.adaptTo(Node.class);
            node.setProperty("eventHandlerTask",event.getTopic()+"-"+resourceResolver.getUserID());
           for(String property: event.getPropertyNames()){
               System.out.println(property+":"+event.getProperty(property));
           }
        } catch (LoginException | RepositoryException e) {
            e.printStackTrace();
        }
    }
}
