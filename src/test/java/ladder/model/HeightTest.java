package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

	@Test
	@DisplayName("사다리의 높이를 생성한다.")
	public void createLadderHeight() {
		Height height = new Height(5);

		assertThat(height).isEqualTo(new Height(5));
		assertThat(height.getHeight()).isEqualTo(5);
	}

	@Test
	@DisplayName("사다리의 높이가 0이하이면 예외가 발생된다.")
	public void checkLimitHeight() {
		assertThrows(IllegalArgumentException.class, () ->
			new Height(0)
		);
	}

}