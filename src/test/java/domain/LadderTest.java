package domain;

import domain.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.Test;

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
		Ladder ladder = new Ladder(2);
		ladder.drawLadder(0, () -> true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_높이가_1일때() {
		Ladder ladder = new Ladder(2);
		ladder.drawLadder(1, () -> true);
	}

	@Test
	public void test_높이만큼_사다리_생성_5개() {
		Ladder ladder = new Ladder(1);
		ladder.drawLadder(5, () -> true);
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getLadderPoints()).hasSize(1);
		Assertions.assertThat(ladderResult.getLadderLayers()).hasSize(5);
	}

	@Test
	public void test_사다리_참가자_3명() {
		Ladder ladder = new Ladder(3);
		ladder.drawLadder(5, () -> true);
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getLadderPoints()).hasSize(3);
		Assertions.assertThat(ladderResult.getLadderLayers()).hasSize(5);
	}

	@Test
	public void test_사다리_이동() {
		Ladder ladder = new Ladder(2);
		ladder.drawLadder(2, () -> true);
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(0))).isEqualTo(Point.of(0));
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(1))).isEqualTo(Point.of(1));
	}

	@Test
	public void test_사다리_이동_4명() {
		Ladder ladder = new Ladder(4);
		ladder.drawLadder(2, () -> true);
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(0))).isEqualTo(Point.of(0));
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(1))).isEqualTo(Point.of(1));
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(2))).isEqualTo(Point.of(2));
		Assertions.assertThat(ladderResult.getEndPointByStartPoint(Point.of(3))).isEqualTo(Point.of(3));
	}
}
