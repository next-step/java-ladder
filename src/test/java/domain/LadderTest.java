package domain;

import domain.dto.GamerDTO;
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
		new Ladder(Arrays.asList("test"), Arrays.asList("꽝"), 0, () -> true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_높이가_1일때() {
		Ladder ladder = new Ladder(Arrays.asList("test"), Arrays.asList("꽝"), 1, () -> true);
	}

	@Test
	public void test_높이만큼_사다리_생성_5개() {
		Ladder ladder = new Ladder(Arrays.asList("test"), Arrays.asList("꽝"), 5, () -> true);
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getGamers()).hasSize(1);
		Assertions.assertThat(ladderResult.getLadderLines()).hasSize(5);
	}

	@Test
	public void test_사다리_참가자_3명() {
		Ladder ladder = new Ladder(Arrays.asList("test1", "test2", "test3"), Arrays.asList("꽝", "1000", "3000"), 5, () -> true);
		ladder.drawLadder();
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getGamers()).hasSize(3);
		Assertions.assertThat(ladderResult.getLadderLines()).hasSize(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_상품수량_인원수가_일치하지않음() {
		new Ladder(Arrays.asList("test1", "test2", "test3"), Arrays.asList("꽝", "1000"), 5, () -> true);
	}

	@Test
	public void test_사다리_이동() {
		Ladder ladder = new Ladder(Arrays.asList("test1", "test2"), Arrays.asList("꽝", "1000"), 2, () -> true);
		ladder.drawLadder();
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();
		GamerDTO gamerDTO = ladderResult.getGamers().get(0);
		Assertions.assertThat(gamerDTO.getPosition()).isEqualTo(0);
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test1")).isEqualTo("꽝");
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test2")).isEqualTo("1000");
	}

	@Test
	public void test_사다리_이동_4명() {
		Ladder ladder = new Ladder(Arrays.asList("test1", "test2", "test3", "test4"),
			Arrays.asList("1", "2", "3", "4"), 2, () -> true);
		ladder.drawLadder();
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();
		GamerDTO gamerDTO = ladderResult.getGamers().get(0);
		Assertions.assertThat(gamerDTO.getPosition()).isEqualTo(0);
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test1")).isEqualTo("1");
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test2")).isEqualTo("2");
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test3")).isEqualTo("3");
		Assertions.assertThat(ladderResult.getGameRewardByGamer("test4")).isEqualTo("4");
	}
}
