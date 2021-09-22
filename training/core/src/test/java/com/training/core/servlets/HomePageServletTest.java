package com.training.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomePageServletTest {

    AemContext  aemContext = new AemContext();
    HomePageServlet unitTest = new HomePageServlet();
    @BeforeEach
    void setUp() {
        aemContext.build().resource("/content/training/us/en","jcr:title","Home Page");
        aemContext.currentResource("/content/training/us/en");
    }

    @Test
    void doGetTest() throws ServletException, IOException {

        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();
        unitTest.doGet(request,response);
        System.out.println(response.getOutputAsString());
        assertEquals("Home Page",response.getOutputAsString());
    }
}