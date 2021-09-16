package com.training.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Iterator;
import java.util.Map;

@Component(service = WorkflowProcess.class,
        property = {
            "process.label="+"Training Workflow"
})
public class CustomWorkflow implements WorkflowProcess {
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        System.out.println("*************************Work Flow Started ************************");
        WorkflowData  workflowData = workItem.getWorkflowData();
        ResourceResolver resourceResolver = workflowSession.adaptTo(ResourceResolver.class);
        if(workflowData.getPayloadType().equals("JCR_PATH")){
            Session session = workflowSession.adaptTo(Session.class);
            String path = workflowData.getPayload().toString()+"/jcr:content";
            try {
                Node node = (Node) session.getItem(path);
                String[] processArgs = metaDataMap.get("PROCESS_ARGS", "string").toString().split(",");
                MetaDataMap dataMap=  workItem.getWorkflow().getWorkflowData().getMetaDataMap();
                for (String processArg:processArgs) {
                    String[] args = processArg.split(":");
                    String prop = args[0];
                    String value = args[1];
                    if(null != node){
                        node.setProperty(prop,value);
                        dataMap.put(prop,value);
                    }

                }
             Iterator<Map.Entry<String, Object>> itr = dataMap.entrySet().iterator();
                while (itr.hasNext()){
                    System.out.println(itr.next());
                }
                System.out.println("*************************Work Flow Started ************************");
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        }
    }
}
