package ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineSketchTest {

	@Test
	@DisplayName("이전 라인이 true 일경우 false 만 가능하디.")
	public void checkLine() {
		assertThat(LineSketch.drawLine(true)).isFalse();
	}

}