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
	@DisplayName("블록 생성")
	void test() {
		Block first = new Block(Direction.RIGHT, new Position(1));

		Block second = first.makeNext(Direction.LEFT);

		assertThat(second.direction()).isEqualTo(Direction.LEFT);
	}
}
