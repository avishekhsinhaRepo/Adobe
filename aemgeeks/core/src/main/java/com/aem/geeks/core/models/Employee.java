package com.aem.geeks.core.models;

import com.day.cq.wcm.api.Page;

import java.util.Iterator;

public interface Employee {
    String getFirstName();
    String getLastName();
    boolean getIsPermanent();
    Iterator<Page> getPages();
}
