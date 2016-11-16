package review;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringWiringTest {

	@Resource
	private ApplicationContext appContext;
	
	@Test
	public void shouldLoadContext() {
		assertNotNull(appContext);
	}
}
