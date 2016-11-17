package review;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
public class ReviewRepositoryTest {

	@Resource
	private ReviewRepository underTest;
	
	@Test
	public void shouldBeACrudRepository() {
		assertTrue(underTest instanceof CrudRepository);
	}
	
	@Test
	public void shouldFindAll() {
		Iterable<Review> allReviews = underTest.findAll();
		Iterator<Review> itr = allReviews.iterator();
		assertTrue(itr.hasNext());
	}

	
	@TestComponent
	public static class AddOneReviewRunner implements CommandLineRunner {

		private ReviewRepository repository;

		public AddOneReviewRunner(ReviewRepository repository) {
			this.repository = repository;
		}

		@Override
		public void run(String... args) {
			Review review = new Review(42, "title", "author", "content", new Date());
			repository.save(review);
		}
		
	}
}
