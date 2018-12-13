package guru.springframework.repositories.reactive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import guru.springframework.domain.Category;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

  @Autowired CategoryReactiveRepository repository;

  @Test
  public void testSave() throws Exception {
    Category category = new Category();
    category.setDescription("Foo");
    repository.save(category).block();

    Long count = repository.count().block();
    assertEquals(Long.valueOf(1), count);
  }
  
  @Test
  public void testFindByDescription() throws Exception {
    Category category = new Category();
    category.setDescription("Foo");
    
    repository.save(category).then().block();

    Category fetchCat = repository.findByDescription("Foo").block();
    assertNotNull(fetchCat.getId());
  }
}
