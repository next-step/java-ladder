package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hspark on 16/11/2018.
 */
public class GamerTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_이름생성_6글자() {
		new Gamer("123456");
	}

	@Test
	public void test_이름생성_5글자() {
		Gamer gamer = new Gamer("12345");
		Assertions.assertThat(gamer.getName()).isEqualTo("12345");
	}
}