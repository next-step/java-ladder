package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Cross;
import ladder.domain.Line;
import ladder.domain.Point;

public class LineTest {

	@Test
	@DisplayName("라인 생성 테스트")
	void lineMakeTest() {
		Line line = new Line(countOfPerson -> {
			Point first = Point.first(false);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(true)));
			crosses.add(new Cross(2, first.next(true).next(false)));
			crosses.add(new Cross(3, first.next(true).next(false).last()));
			return crosses;
		}, 4);
		assertThat(line.getCrosses().size()).isEqualTo(4);
	}

	@Test
	@DisplayName("라인 생성 랜덤 테스트")
	void lineMakeRandomTest() {
		Line line = new Line(5);
		assertThat(line.getCrosses().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("라인 이동 테스트")
	void lineMoveTest() {
		Line line = new Line(countOfPerson -> {
			Point first = Point.first(false);
			Point second = first.next(true);
			Point third = second.next(false);
			Point fourth = third.last();
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, second));
			crosses.add(new Cross(2, third));
			crosses.add(new Cross(3, fourth));
			return crosses;
		}, 4);

		assertThat(line.movePoint(0)).isEqualTo(0);
		assertThat(line.movePoint(1)).isEqualTo(2);
		assertThat(line.movePoint(2)).isEqualTo(1);
		assertThat(line.movePoint(3)).isEqualTo(3);
	}
}
