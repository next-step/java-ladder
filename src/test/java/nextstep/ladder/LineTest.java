package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Bridge;
import nextstep.ladder.domain.Line;

class LineTest {

	@Test
	void 라인_생성_테스트() {
		final int numberOfPeople = 4;
		final Line line = new Line(() -> true, numberOfPeople);
		assertThat(line.getBridges()).isEqualTo(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE, Bridge.BRIDGE));
	}

	@Test
	@DisplayName("다리가 왼쪽에 있으면 -1을 반환한다")
	void testMoveLeft() {
		final Line line = new Line(() -> true, 4);
		final int canMove = line.move(1);
		assertThat(canMove).isEqualTo(-1);
	}

	@Test
	@DisplayName("다리가 오른쪽에 있으면 1을 반환한다")
	void testMoveRight() {
		final Line line = new Line(() -> true, 4);
		final int canMove = line.move(2);
		assertThat(canMove).isEqualTo(1);
	}

	@Test
	@DisplayName("다리가 없으면 건너지 못한다")
	void testNonMove() {
		final Line line = new Line(() -> false, 4);
		final int canMove = line.move(1);
		assertThat(canMove).isEqualTo(0);
	}
}