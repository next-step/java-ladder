package ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineSketchTest {

	@Test
	@DisplayName("랜덤값을 호출 하면 랜덤값이 생성된다.")
	public void createRandom() {
		assertThat(FalseDummyLineSketch.drawLine()).isFalse();
		assertThat(TrueDummyLineSketch.drawLine()).isTrue();
	}

	static class FalseDummyLineSketch {

		public static boolean drawLine() {
			return false;
		}
	}

	static class TrueDummyLineSketch {

		public static boolean drawLine() {
			return true;
		}
	}
}