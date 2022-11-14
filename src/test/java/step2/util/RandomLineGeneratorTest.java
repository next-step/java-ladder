package step2.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.model.Users;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RandomLineGeneratorTest {

	Users users;

	@BeforeEach
	void beforeEach(){
		users = new Users("a,b,c,d");
	}

	@Test
	void generate() {
		RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
		assertTrue(randomLineGenerator.generate(users) instanceof ArrayList);
		assertTrue(randomLineGenerator.generate(users).get(0) instanceof Boolean);
	}
}