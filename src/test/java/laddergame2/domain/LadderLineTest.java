package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderLineTest {

	@Test
	public void 생성_확인() {
		LadderLine ladderLine = LadderLine.init(4);

		System.out.println(ladderLine);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어가_2명_미만일때_선_생성_오류() {
		LadderLine.init(1);
	}

	@Test
	public void 왼쪽_이동() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, TRUE)),
						Point.of(1, Direction.of(TRUE, FALSE)),
						Point.of(2, Direction.of(FALSE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(0);
	}

	@Test
	public void 오른쪽_이동() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, FALSE)),
						Point.of(1, Direction.of(FALSE, TRUE)),
						Point.of(2, Direction.of(TRUE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(2);
	}

	@Test
	public void 직진() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, FALSE)),
						Point.of(1, Direction.of(FALSE, FALSE)),
						Point.of(2, Direction.of(FALSE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(1);
	}
}
