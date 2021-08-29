package com.aem.geeks.core.models.impl;

import com.aem.geeks.core.beans.Student;
import com.aem.geeks.core.models.StudentModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


import javax.inject.Inject;

@Model(adapters = StudentModel.class,
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StudentModelImpl implements StudentModel {
    @Inject
    @Default(values = "No First name")
    String sfname;
    @Inject
    @Default(values = "No Last name")
    String slname;

    @Override
    public Student getStudentInfo() {
        System.out.println(sfname +slname);
        Student student = new Student(sfname,slname);
        return student;
    }
}
