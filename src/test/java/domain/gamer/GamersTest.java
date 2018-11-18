package domain.gamer;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hspark on 18/11/2018.
 */
public class GamersTest {

	@Test
	public void test_생성() {
		Gamers gamers = new Gamers(Arrays.asList("test"));
		Gamer gamer = gamers.findByGamerName("test");
		Assertions.assertThat(gamer.isEqualName("test")).isTrue();
	}
}