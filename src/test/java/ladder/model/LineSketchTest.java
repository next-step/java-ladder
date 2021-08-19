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

	@Test
	@DisplayName("랜덤값을 호출 하면 랜덤값이 생성된다.")
	public void createRandom() {
		assertThat(FalseLineSketch.drawLine()).isFalse();
		assertThat(TrueLineSketch.drawLine()).isTrue();
	}

	static class FalseLineSketch {
		public static boolean drawLine() {
			return false;
		}
	}

	static class TrueLineSketch {
		public static boolean drawLine() {
			return true;
		}
	}
}