package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionMoveMatchTest {

	@Test
	@DisplayName("이동 안하기")
	void not_move() {
		// given
		Root root = new Root(() -> false);
		int position = 0;
		int rootIndex = 0;

		// when
		Position position1 = PositionMoveMatch.getMatchPosition(root, rootIndex, new Position(position));

		// then
		assertThat(position1.getPosition())
			.isEqualTo(0);
	}

	@Test
	@DisplayName("오른쪽으로 이동")
	void move_Right() {
		// given
		Root root = new Root(() -> true);
		int position = 0;
		int rootIndex = 0;

		// when
		Position position1 = PositionMoveMatch.getMatchPosition(root, rootIndex, new Position(position));

		// then
		assertThat(position1.getPosition())
			.isEqualTo(1);
	}

	@Test
	@DisplayName("왼쪽으로 이동")
	void move_Left() {
		// given
		Root root = new Root(() -> true);
		int position = 1;
		int rootIndex = 0;

		// when
		Position position1 = PositionMoveMatch.getMatchPosition(root, rootIndex, new Position(position));

		// then
		assertThat(position1.getPosition())
			.isEqualTo(0);
	}
}
