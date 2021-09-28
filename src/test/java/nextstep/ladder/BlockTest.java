package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Block;
import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Position;

public class BlockTest {

	@Test
	@DisplayName("오른쪽 방향성 블록 시작")
	void right() {
		Block first = new Block(Direction.RIGHT, new Position(1));

		Block second = first.makeNext(Direction.LEFT);

		assertThat(second.direction()).isEqualTo(Direction.LEFT);
	}

	@Test
	@DisplayName("정지 방향성 블록 시작")
	void stop() {
		Block first = new Block(Direction.NOTHING, new Position(1));

		Block second = first.makeNext(Direction.NOTHING);

		assertThat(second.direction()).isEqualTo(Direction.NOTHING);

		Block third = second.makeNext(Direction.RIGHT);

		assertThat(third.direction()).isEqualTo(Direction.RIGHT);
	}

	@Test
	@DisplayName("왼쪽 방향성 블록 시작")
	void left() {
		Block first = new Block(Direction.LEFT, new Position(2));

		Block second = first.makeNext(Direction.RIGHT);

		assertThat(second.direction()).isEqualTo(Direction.RIGHT);

		Block third = second.makeNext(Direction.LEFT);

		assertThat(third.direction()).isEqualTo(Direction.LEFT);

		Block forth = third.makeNext(Direction.NOTHING);

		assertThat(forth.direction()).isEqualTo(Direction.NOTHING);
	}

	@Test
	@DisplayName("오른쪽 이동")
	void rightMove() {
		Block first = new Block(Direction.RIGHT, new Position(1));

		Participant participant = new Participant("test", new Position(1));

		first.enter(participant);

		assertThat(participant.position()).isEqualTo(new Position(2));
	}

	@Test
	@DisplayName("왼쪽 이동")
	void leftMove() {
		Block first = new Block(Direction.LEFT, new Position(1));

		Participant participant = new Participant("test", new Position(2));

		first.enter(participant);

		assertThat(participant.position()).isEqualTo(new Position(1));
	}

	@Test
	@DisplayName("정지")
	void notMove() {
		Block first = new Block(Direction.NOTHING, new Position(1));

		Participant participant = new Participant("test", new Position(1));

		first.enter(participant);

		assertThat(participant.position()).isEqualTo(new Position(1));
	}
}
