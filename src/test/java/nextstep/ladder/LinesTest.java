package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Lines;

public class LinesTest {

	@Test
	@DisplayName("사다리 높이만큼 라인 생성, 높이가 0보다 커야함")
	void test() {
		Lines lines = new Lines(2, 5);

		assertThat(lines.list().size()).isEqualTo(5);

		assertThatThrownBy(() -> {
			new Lines(2, 0);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
