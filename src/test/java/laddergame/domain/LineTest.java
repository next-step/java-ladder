package laddergame.domain;

import static com.google.common.primitives.Booleans.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LineTest {

	@Test
	public void 라인_문자열_생성() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		assertThat(line.draw()).isEqualTo("     |-----|     |-----|");
	}
}
