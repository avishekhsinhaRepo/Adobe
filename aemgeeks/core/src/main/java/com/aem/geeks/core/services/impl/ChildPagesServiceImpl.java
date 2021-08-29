package com.aem.geeks.core.services.impl;

import com.aem.geeks.core.services.ChildPagesService;
import com.aem.geeks.core.utils.ResolverUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = ChildPagesService.class, immediate = true)
public class ChildPagesServiceImpl implements ChildPagesService {
    private static final Logger logger = LoggerFactory.getLogger(ChildPagesServiceImpl.class);
    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public Iterator<Page> getPages() {
        try {
            List<String> pageTitles = new ArrayList<String>();
            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            Page page = pageManager.getPage("/content/aemgeeks/us/en");
            Iterator<Page> pages = page.listChildren();
            return pages;
        } catch (LoginException e) {
            logger.info("\n Login Exception {} ", e.getMessage());
        }
        return null;
    }

    @Activate
    public void activate(ComponentContext componentContext) {
        logger.info("************* Activate Method Called ***************");
        logger.info("\n {} ={}", componentContext.getBundleContext().getBundle().getBundleId(),
                componentContext.getBundleContext().getBundle().getSymbolicName());
        logger.info("************* Activate Method End ***************");
    }

    @Deactivate
    public void deActivate() {
        logger.info("************* Deactivate Method Called ***************");
    }

    @Modified
    public void modified() {
        logger.info("************* Modified Method Called ***************");
    }
}
