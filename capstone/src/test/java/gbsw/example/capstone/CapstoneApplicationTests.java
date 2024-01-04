package gbsw.example.capstone;

import gbsw.example.capstone.domain.Booktext;
import gbsw.example.capstone.repository.RandomIn;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapstoneApplicationTests {

	@Autowired
	private RandomIn randomIn;

	@Test
	public void testFindByCode() {

	}
}