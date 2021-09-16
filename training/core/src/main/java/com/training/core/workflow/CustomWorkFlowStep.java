package com.training.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Component(service = WorkflowProcess.class,property = {
        "process.label="+"This is custom workflow Step"
})
public class CustomWorkFlowStep implements WorkflowProcess {
    Logger logger = LoggerFactory.getLogger(CustomWorkFlowStep.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        logger.info("************* Executing Process Step ***************");
                WorkflowData workflowData = workItem.getWorkflowData();
                if(workflowData.getPayloadType().equals("JCR_PATH")){
                    String payload = workflowData.getPayload().toString()+"/jcr:content";
                    Session session = workflowSession.adaptTo(Session.class);
                    try {
                        Node node = (Node) session.getItem(payload);
                        if(null!= node){
                            String brand = metaDataMap.get("BRAND", StringUtils.EMPTY);
                            boolean isMultiNational = metaDataMap.get("MULTINATIONAL", false);
                            String[] countries = metaDataMap.get("COUNTRIES", String[].class);
                            node.setProperty("brand",brand);
                            node.setProperty("isMultiNational",isMultiNational);
                            node.setProperty("countries",countries);
                        }
                    } catch (RepositoryException e) {
                        e.printStackTrace();
                    }
                }


    }
}
