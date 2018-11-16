package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hspark on 16/11/2018.
 */

/**
 * 1. 입력받은 사다리 높이 만큼 사다리 라인의 리스트를 만든다.
 * 2. 메시지를 보내면 각 사다리 라인들에게 높이 만큼 그리라고 메시지을 보낸다.
 */
public class LadderTest {

	@Test(expected = IllegalArgumentException.class)
	public void test_높이가_0일때() {
		Ladder ladder = new Ladder(Arrays.asList("test"), 0, () -> true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_높이가_1일때() {
		Ladder ladder = new Ladder(Arrays.asList("test"), 1, () -> true);
	}

	@Test
	public void test_높이만큼_사다리_생성_5개() {
		Ladder ladder = new Ladder(Arrays.asList("test"), 5, () -> true);
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getGamers()).hasSize(1);
		Assertions.assertThat(ladderResult.getLadderLines()).hasSize(5);
	}

	@Test
	public void test_사다리_참가자_3명() {
		Ladder ladder = new Ladder(Arrays.asList("test1", "test2", "test3"), 5, () -> true);
		ladder.drawLadder();
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getGamers()).hasSize(3);
		Assertions.assertThat(ladderResult.getLadderLines()).hasSize(5);
	}
}
