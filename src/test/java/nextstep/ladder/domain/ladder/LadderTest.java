package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.linestrategy.ManualLineGenerator;
import nextstep.ladder.domain.linestrategy.RandomLineGenerator;

class LadderTest {

	public static final Ladder MANUAL_LADDER = new Ladder(
		List.of(
			new Line(4, new ManualLineGenerator(List.of(true, false, false))),
			new Line(4, new ManualLineGenerator(List.of(false, true, false))),
			new Line(4, new ManualLineGenerator(List.of(false, true, false)))
		)
	);

	@DisplayName("ladder 의 사이즈는 height 이다.")
	@Test
	void Given_Height_Then_GenerateLadder() {
		int height = 2;
		Ladder ladder = new Ladder(1, height, new RandomLineGenerator());

		assertThat(ladder.getLadder()).hasSize(height);
	}

	@DisplayName("시작 포인트를 입력하면 결과 포인트를 반환한다.")
	@Test
	void Given_StartPoint_Then_ReturnEndPoint() {
		int start = 0;

		assertThat(MANUAL_LADDER.getEnd(start)).isEqualTo(1);
	}
}