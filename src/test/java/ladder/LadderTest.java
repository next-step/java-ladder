package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Ladder;
import ladder.domain.Line;

public class LadderTest {

	@Test
	@DisplayName("사다리 생성 테스트")
	void ladderMakeTest() {
		Line line1 = new Line(countOfPerson -> {
			List<Boolean> points = new ArrayList<>();
			points.add(false);
			points.add(true);
			points.add(false);
			points.add(false);
			return points;
		}, 4);

		Line line2 = new Line(countOfPerson -> {
			List<Boolean> points = new ArrayList<>();
			points.add(false);
			points.add(true);
			points.add(false);
			points.add(false);
			return points;
		}, 4);

		Line line3 = new Line(countOfPerson -> {
			List<Boolean> points = new ArrayList<>();
			points.add(false);
			points.add(true);
			points.add(false);
			points.add(false);
			return points;
		}, 4);
		Ladder ladder = new Ladder(line1, line2, line3);

		assertThat(ladder.getLadder()).containsExactly(line1, line2, line3);
		assertThat(ladder.getLadder()).hasSize(3);
	}

	@Test
	@DisplayName("사다리 생성 테스트2")
	void ladderMake2Test() {
		Ladder ladder = new Ladder(4, 5);
		assertThat(ladder.getLadder()).hasSize(5);
		assertThat(ladder.getLadder().get(0).getPoints()).hasSize(4);
		assertThat(ladder.getLadder().get(0).getPoints().get(3)).isEqualTo(false);
		assertThat(ladder.getLadder().get(1).getPoints().get(3)).isEqualTo(false);
		assertThat(ladder.getLadder().get(2).getPoints().get(3)).isEqualTo(false);
		assertThat(ladder.getLadder().get(3).getPoints().get(3)).isEqualTo(false);
		assertThat(ladder.getLadder().get(4).getPoints().get(3)).isEqualTo(false);

	}
}
