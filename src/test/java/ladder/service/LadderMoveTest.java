package ladder.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderMoveTest {

	@Test
	@DisplayName("시작 위치정보와 라인을 입력하면 이동경로를 반환한다.")
	public void moveLine() {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(true);
		points.add(false);

		assertThat(LadderMove.move(0, points)).isEqualTo(1);
		assertThat(LadderMove.move(1, points)).isEqualTo(0);
		assertThat(LadderMove.move(2, points)).isEqualTo(2);
	}
}