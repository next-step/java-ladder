package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Cross;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;

public class LadderTest {
	private Line line1;
	private Line line2;
	private Line line3;
	private Ladder ladder;

	@BeforeEach
	void setUp() {
		line1 = new Line(countOfPerson -> {
			Point first = Point.first(true);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(false)));
			crosses.add(new Cross(2, first.next(false).next(true)));
			crosses.add(new Cross(3, first.next(false).next(true).last()));
			return crosses;
		}, 4);

		line2 = new Line(countOfPerson -> {
			Point first = Point.first(false);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(true)));
			crosses.add(new Cross(2, first.next(true).next(false)));
			crosses.add(new Cross(3, first.next(true).next(false).last()));
			return crosses;
		}, 4);

		line3 = new Line(countOfPerson -> {
			Point first = Point.first(false);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(true)));
			crosses.add(new Cross(2, first.next(true).next(false)));
			crosses.add(new Cross(3, first.next(true).next(false).last()));
			return crosses;
		}, 4);

		List<Line> lines = new ArrayList<>();
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);

		ladder = new Ladder(lines);
	}

	@Test
	@DisplayName("사다리 생성 테스트")
	void ladderMakeTest() {
		assertThat(ladder.getLadder()).containsExactly(line1, line2, line3);
		assertThat(ladder.getLadder()).hasSize(3);
	}

	@Test
	@DisplayName("사다리 생성 테스트2")
	void ladderMake2Test() {
		Ladder ladder = new Ladder(4, 5);
		assertThat(ladder.getLadder()).hasSize(5);
		assertThat(ladder.getLadder().get(0).getCrosses()).hasSize(4);

	}

	@Test
	@DisplayName("사다리 이동 테스트")
	void ladderMoveTest() {
		assertThat(ladder.moveLine(0)).isEqualTo(1);
		assertThat(ladder.moveLine(1)).isEqualTo(0);
		assertThat(ladder.moveLine(2)).isEqualTo(3);
		assertThat(ladder.moveLine(3)).isEqualTo(2);

	}
}
