package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineTest {

	@Test
	void 라인_root_size_check() {
		// given
		int size = 5;

		// when
		Line line = new Line(size);

		// then
		assertThat(line.getRoots()
			.size())
			.isEqualTo(size - 1);
	}
}
