package ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

	@Test
	@DisplayName("왼쪽에 선이있고 오른쪽에 선이없으면 위치에 -1을 한다.")
	public void moveLeftPosition() {
		int result = Direction.movePosition(true, false, 2);

		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("왼쪽에 선이없고 오른쪽에 선이있으면 위치에 +1을 한다.")
	public void moveRightPosition() {
		int result = Direction.movePosition(false, true, 2);

		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("왼쪽에 선이없고 오른쪽에도 선이 없으면 위치에 그대로 반환 한다.")
	public void moveStopPosition() {
		int result = Direction.movePosition(false, false, 2);

		assertThat(result).isEqualTo(2);
	}

}