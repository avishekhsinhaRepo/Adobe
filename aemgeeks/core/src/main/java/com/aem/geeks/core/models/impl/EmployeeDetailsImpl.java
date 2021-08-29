package com.aem.geeks.core.models.impl;

import com.aem.geeks.core.beans.User;
import com.aem.geeks.core.models.EmployeeDetails;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, adapters = EmployeeDetails.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeDetailsImpl implements EmployeeDetails {

    @ValueMapValue
    @Default(values = "AEM Geeks")
    String empName;

    @ValueMapValue
    List<String> skills;

    @Override
    public String getEmployeeName() {
        return empName;
    }

    @ScriptVariable
    PageManager pageManager;

    @Override
    public List<String> getSkills() {
        if (skills != null) {
            return new ArrayList<>(skills);
        }
        return Collections.emptyList();
    }

    @Override
    public Map<String, String> getCustomMap() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("EMP1","REX");
        map.put("EMP2","RAM");
        map.put("EMP3","ROB");
        return map;
    }

    @Override
    public List<Map<String, String>> getCustomListOfMap() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");

        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("key11","value11");
        map2.put("key22","value22");
        return Arrays.asList( map,map2);
    }

    @Override
    public List<User> getUserList() {
       return Arrays.asList(
                new User("M1","Mike"),new User("M2","Max") );
    }

    @Override
    public Iterator<Page> getPages() {
        Page page = pageManager.getPage("/content/aemgeeks/us/en");
        Iterator<Page>  child = page.listChildren();
        return  child;
    }

}
