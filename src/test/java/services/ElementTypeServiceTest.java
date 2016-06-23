package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
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
public class ElementTypeServiceTest {

    @Autowired
    public ElementTypeService elementTypeService;

    @Test
    public void elementTypeServiceTest() {
        ElementType elementType = new ElementType("ServiceTest");

        assertNull(elementType.getId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getId());
    }
}
