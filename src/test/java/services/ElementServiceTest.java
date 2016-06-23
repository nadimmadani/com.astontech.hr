package services;
import com.astontech.hr.Application;
import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by ryanmada1 on 6/14/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementServiceTest {

    @Autowired
    public ElementServices elementServices;

    @Test
    public void elementServiceSaveTest() {
        Element element = new Element("ServiceTest");

        //save element, verify it has an ID after the save.
        assertNull(element.getId());
        elementServices.saveElement(element);
        assertNotNull(element.getId());

        //fetch

        Element fetchedElement = elementServices.getElementById(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementServices.saveElement(fetchedElement);

        Element updatedElement = elementServices.getElementById(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
    }

}


