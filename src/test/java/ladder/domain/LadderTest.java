package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

	@DisplayName("유효한 좌표 목록으로 사다리 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Ladder ladder = Ladder.of(new Points(true, false, true), new Points(false, true, false));
		assertThat(ladder).isEqualTo(Ladder.of(new Points(true, false, true), new Points(false, true, false)));
	}
}
