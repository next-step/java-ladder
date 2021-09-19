package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Position;

public class ParticipantTest {
	@Test
	@DisplayName("이름이 5자를 초과할 수 없습니다.")
	void test() {
		assertThatThrownBy(() -> {
			new Participant("5자초과이름");
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("사람 오른쪽, 왼쪽 이동")
	void move() {
		Participant participant = new Participant("pobi", new Position(1));
		participant.move(Direction.LEFT);

		assertThat(participant.position()).isEqualTo(new Position(0));

		participant.move(Direction.RIGHT);

		assertThat(participant.position()).isEqualTo(new Position(1));
	}
}
