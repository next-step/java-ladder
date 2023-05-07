package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

	@DisplayName("사다리를 생성한다.")
	@Test
	void test1() {
		Ladder ladder = Ladder.of(new Points(true, false, true), new Points(false, true, false));
		assertThat(ladder).isEqualTo(Ladder.of(new Points(true, false, true), new Points(false, true, false)));
	}
}
