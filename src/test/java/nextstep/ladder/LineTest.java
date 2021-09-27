package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Block;
import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Position;

public class LineTest {

	@Test
	@DisplayName("사람의 수만큼 블록을 생성, 사람 수는 1보다 커야함")
	void test() {
		Line line = new Line(5);

		assertThat(line.blocks().size()).isEqualTo(5);

		assertThatThrownBy(() -> {
			new Line(1);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("라인에서 좌표에 해당하는 블록에 적용 받음")
	void test2() {
		Line line = new Line(4);
		int testPosition = 2;
		Participant participant = new Participant("test", new Position(testPosition));
		line.play(participant);

		Participant participant2 = new Participant("test2", new Position(testPosition));
		line.play(participant2);

		assertThat(participant.position()).isEqualTo(participant2.position());
	}

	@Test
	@DisplayName("오른쪽일때 왼쪽 블랙 생성, 왼쪽 or 정지일때 오른쪽 or 정지 생성")
	void test3() {
		Line line = new Line(5);
		Direction prev = Direction.NOTHING;
		for (Block block : line.blocks()) {
			if(prev == Direction.RIGHT) {
				assertThat(block.direction()).isEqualTo(Direction.LEFT);
				prev = block.direction();
				continue;
			}
			assertThat(block.direction()).isIn(Direction.RIGHT, Direction.NOTHING);
			prev = block.direction();
		}
	}
}
