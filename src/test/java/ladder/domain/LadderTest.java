package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

	@DisplayName("유효한 좌표 목록으로 사다리 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Ladder ladder = Ladder.of(Line.of(true, false, true), Line.of(false, true, false));
		assertThat(ladder).isEqualTo(Ladder.of(Line.of(true, false, true), Line.of(false, true, false)));
	}

	@DisplayName("유효한 사다리 생성 후, 최종 인덱스를 구한다.")
	@Test
	void test2() {
		Ladder ladder = Ladder.of(
			Line.of(true, false, true),
			Line.of(false, true, false),
			Line.of(true, false, false),
			Line.of(false, true, false),
			Line.of(true, false, true)
		);

		assertThat(ladder.finalIndex(0)).isEqualTo(0);
		assertThat(ladder.finalIndex(1)).isEqualTo(3);
		assertThat(ladder.finalIndex(2)).isEqualTo(2);
		assertThat(ladder.finalIndex(3)).isEqualTo(1);
	}
}
