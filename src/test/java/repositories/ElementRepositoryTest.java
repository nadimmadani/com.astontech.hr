package repositories;

import com.astontech.hr.Application;
import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by ryanmada1 on 6/14/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {


    private ElementRepository elementRepository;

    @Autowired
    public void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @Test
    public void testSavingElement() {
        // setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify it has an ID after the save.
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        //fetch

        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
    }

//    @Test
//    public void testSaveElementList() {
//        List<Element> elementList= new ArrayList<>();
//
//        elementList.add(new Element("Phone"));
//        elementList.add(new Element("Email"));
//        elementList.add(new Element("Laptop"));
//        elementList.add(new Element("PayRate"));
//
//        elementRepository.save(elementList);
//
//        Iterable<Element> fetchedElementList = elementRepository.findAll();
//
//        int count = 0;
//        for(Element element: fetchedElementList) {
//            count = count + 1;
//            System.out.println(element.getElementName());
//        }
//        assertEquals(5, count);
//    }

    @Test
    public void findByName() {
        Element element = new Element("FindTestSingle");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTestSingle");

        assertEquals(element.getId(), foundByNameElement.getId());
    }

    @Test
    public void findAllByName() {
        Element element = new Element("FindTest");
        elementRepository.save(element);
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundAllByNameElement.size());
    }


}
