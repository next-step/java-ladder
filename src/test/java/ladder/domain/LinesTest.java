package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

	@DisplayName("유효한 가로 라인 목록 생성 후, 최종 인덱스를 구한다.")
	@Test
	void test1() {
		Lines lines = Lines.of(
			Line.of(Crosses.of(true, false, true)),
			Line.of(Crosses.of(false, true, false)),
			Line.of(Crosses.of(true, false, false)),
			Line.of(Crosses.of(false, true, false)),
			Line.of(Crosses.of(true, false, true))
		);

		assertThat(lines.finalIndex(0)).isEqualTo(0);
		assertThat(lines.finalIndex(1)).isEqualTo(3);
		assertThat(lines.finalIndex(2)).isEqualTo(2);
		assertThat(lines.finalIndex(3)).isEqualTo(1);
	}
}
