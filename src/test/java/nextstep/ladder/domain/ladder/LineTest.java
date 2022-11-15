package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.linestrategy.ManualLineGenerator;
import nextstep.ladder.domain.linestrategy.RandomLineGenerator;

class LineTest {

	public static final Line LINE = new Line(6, new ManualLineGenerator(List.of(true, false, true, false, false)));

	@DisplayName("Line 의 사이즈는 length - 1 이다.")
	@Test
	void Given_Length_Then_GenerateLadder() {
		int length = 2;
		Line line = new Line(length, new RandomLineGenerator());

		assertThat(line.getPoints()).hasSize(length - 1);
	}

	@DisplayName("오른쪽 라인이 있는 경우 true 를 반환한다.")
	@Test
	void Given_HasRightLine_Then_True() {
		assertThat(LINE.hasRightLine(0)).isTrue();
	}

	@DisplayName("오른쪽 라인이 없는 경우 true 를 반환한다.")
	@Test
	void Given_HasNoRightLine_Then_False() {
		assertThat(LINE.hasRightLine(1)).isFalse();
	}

	@DisplayName("왼쪽 라인이 있는 경우 true 를 반환한다.")
	@Test
	void Given_HasLeftLine_Then_True() {
		assertThat(LINE.hasLeftLine(1)).isTrue();
	}

	@DisplayName("왼쪽 라인이 없는 경우 true 를 반환한다.")
	@Test
	void Given_HasNoLeftLine_Then_False() {
		assertThat(LINE.hasLeftLine(0)).isFalse();
	}

	@DisplayName("라인이 존재하는 경우 true 를 반환한다.")
	@Test
	void Given_HasLine_Then_True() {
		assertThat(LINE.hasLine(1)).isTrue();
	}

	@DisplayName("라인이 존재하지 않는 경우 false 를 반환한다.")
	@Test
	void Given_HasNoLine_Then_False() {
		assertThat(LINE.hasLine(5)).isFalse();
	}

	@DisplayName("다음 라인에서 포인트를 반환한다.")
	@Test
	void Given_Point_Then_NextPoint() {
		assertThat(LINE.getNextPoint(0)).isEqualTo(1);
	}
}