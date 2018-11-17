package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 16/11/2018.
 */


/**
 * 1. 사용자는 해당 사다리 라인이 이동 가능한지 확인한다.
 * 2. 이동 가능하면 위치를 바꾼다.
 */
public class GamerTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_게이머생성_6글자() {
		new Gamer("123456");
	}

	@Test
	public void test_게이머생성_5글자() {
		Gamer gamer = new Gamer("12345");
		Assertions.assertThat(gamer.getName()).isEqualTo("12345");
	}

	@Test
	public void test_이동가능_플레이어() {
		LadderLine ladderLine = new LadderLine(0, 1);
		Gamer gamer = new Gamer("test", 0);
		boolean isPassable = gamer.isPassable(ladderLine);
		Assertions.assertThat(isPassable).isTrue();
	}

	@Test
	public void test_해당사다리_위치_이동() {
		LadderLine ladderLine = new LadderLine(0, 1);
		Gamer gamer = new Gamer("test", 0);
		gamer.passLine(ladderLine);
		Assertions.assertThat(gamer.getPosition()).isEqualTo(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_이동불가능한_사다리() {
		LadderLine ladderLine = new LadderLine(0, 1);
		Gamer gamer = new Gamer("test", 2);
		gamer.passLine(ladderLine);
	}
}