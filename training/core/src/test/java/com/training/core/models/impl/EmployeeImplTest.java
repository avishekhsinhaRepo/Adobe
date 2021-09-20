package com.training.core.models.impl;

import com.training.core.models.Employee;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class EmployeeImplTest {

    private final AemContext aemContext = new AemContext();

    Employee employee;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(EmployeeImpl.class);
        aemContext.load().json("/com/Employee.json","/component");
        aemContext.load().json("/com/Page.json","/pages");
        aemContext.load().json("/com/Resource.json","/resource");
    }

    @Test
    void getFirstName() {
        aemContext.currentResource("/component/employee");
        employee = aemContext.request().adaptTo(Employee.class);
        assertEquals("JO",employee.getFirstName());
    }

    @Test
    void getLastName() {
        aemContext.currentResource("/component/employee");
        employee = aemContext.request().adaptTo(Employee.class);
        assertEquals("Doe11",employee.getLastName());
    }

    @Test
    void isPermanent() {
        aemContext.currentResource("/component/employee");
        employee = aemContext.request().adaptTo(Employee.class);
        assertTrue(employee.isPermanent());
    }

    @Test
    void getFullName() {

    }

    @Test
    void getHomePageName() {
        Resource res = aemContext.currentResource("/resource/resourcePage");
        EmployeeImpl employeeImpl = aemContext.registerService(new EmployeeImpl());
        employeeImpl.homePageResource = res;
        assertEquals("resourcePage",employeeImpl.getHomePageName());
    }

    @Test
    void getPageTitle() {
        aemContext.currentPage("/pages/currentPage");
        employee = aemContext.request().adaptTo(Employee.class);
        assertEquals("Training Project",employee.getPageTitle());
    }

    @Test
    void getResourcePrimaryType() {
    }

    @Test
    void getRequestAttribute() {
        aemContext.request().setAttribute("companyName","ABC");
        employee = aemContext.request().adaptTo(Employee.class);
        assertEquals("ABC",employee.getRequestAttribute());
    }
}