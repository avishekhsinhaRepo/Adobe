package com.aem.geeks.core.models;

import com.aem.geeks.core.beans.User;
import com.day.cq.wcm.api.Page;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface EmployeeDetails {
    String getEmployeeName();
    List<String> getSkills();
    Map<String,String> getCustomMap();
    List<Map<String,String>> getCustomListOfMap();
    List<User> getUserList();
    Iterator<Page> getPages();
}
