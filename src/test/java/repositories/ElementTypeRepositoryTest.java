package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by ryanmada1 on 6/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {


    private ElementTypeRepository elementTypeRepository;

    @Autowired
    public void setElementTypeRepository(ElementTypeRepository elementTypeRepository) {
        this.elementTypeRepository = elementTypeRepository;
    }

    @Test
    public void findByType() {
        ElementType elementType = new ElementType("Phone");
        elementTypeRepository.save(elementType);
        ElementType foundByType = elementTypeRepository.findOne(1);

        assertEquals(elementType.getId(), foundByType.getId());
    }
}
