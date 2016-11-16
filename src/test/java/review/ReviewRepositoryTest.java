package review;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewRepositoryTest {

	@Resource
	private ReviewRepository underTest;
	
	@Before
	public void addAReview() {
		Review review = new Review(42, "title", "author", "content", new Date());
		underTest.save(review);
	}
	
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
	
//	@Configuration
//	public static class TestConfiguration {
//		@Bean
//		public CommandLineRunner addAReview(final ReviewRepository repository) {
//			return new AddOneReviewRunner(repository);
//		}
//	}
//	
//	public static class AddOneReviewRunner implements CommandLineRunner {
//
//		private ReviewRepository repository;
//
//		public AddOneReviewRunner(ReviewRepository repository) {
//			this.repository = repository;
//		}
//
//		@Override
//		public void run(String... args) {
//			
//		}
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
}
