package domain.gamer;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 16/11/2018.
 */

public class GamerTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_게이머생성_6글자() {
		new Gamer("123456", 0);
	}

	@Test
	public void test_게이머생성_5글자() {
		Gamer gamer = new Gamer("12345", 0);
		Assertions.assertThat(gamer.getName()).isEqualTo("12345");
	}
}