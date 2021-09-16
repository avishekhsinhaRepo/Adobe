package com.training.core.listeners;


import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

@Component(service = EventListener.class,immediate = true)
public class JCREventHandler implements EventListener {

    private static final Logger log = LoggerFactory.getLogger(JCREventHandler.class);

    private Session session = null;

    @Reference
    SlingRepository slingRepository;

    @Activate
    protected void activate() throws RepositoryException {
        String[] nodetypes={"cq:PageContent"};
        session = slingRepository.loginService("training-user",null);
        session.getWorkspace().getObservationManager().addEventListener(this,
                Event.NODE_ADDED| Event.PROPERTY_ADDED,
                "/content/training",true,null,nodetypes,true);
    }
    @Override
    public void onEvent(EventIterator eventIterator) {
        while(eventIterator.hasNext()){
            try {
                System.out.println("The updated path= "+eventIterator.nextEvent().getPath());
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        }
    }
}
