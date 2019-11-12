package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.Participants;
import ladder.domain.line.Line;
import ladder.domain.point.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

	@Test
	void 사다리를_그리면_수평_수직으로_연결된다() {
		/* 기대하고 있는 사다리 모양
		 * |-----|     |
		 * |-----|     |
		 * |-----|     |
		 */

		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};

		// when
		Ladder ladder = new Ladder(() -> true, new Participants(names), 3);

		// then
		List<Line> middleLines = ladder.getLines().subList(1, 3);
		for (Line line : middleLines) {
			assertLineHasVerticalAndHorizontalConnection(line);
		}
	}

	private void assertLineHasVerticalAndHorizontalConnection(Line line) {
		List<Point> points = line.getPoints();

		assertPointHasVerticalConnection(points.get(0));
		assertPointHasVerticalConnection(points.get(1));
		assertPointHasVerticalConnection(points.get(2));

		assertPointHasHorizontalConnection(points.get(0));
		assertPointHasNotHorizontalConnection(points.get(1));
		assertPointHasNotHorizontalConnection(points.get(2));
	}

	private void assertPointHasVerticalConnection(Point point) {
		assertThat(point.hasConnection(Direction.VERTICAL)).isTrue();
	}

	private void assertPointHasHorizontalConnection(Point point) {
		assertThat(point.hasConnection(Direction.HORIZONTAL)).isTrue();
	}

	private void assertPointHasNotHorizontalConnection(Point point) {
		assertThat(point.hasConnection(Direction.HORIZONTAL)).isFalse();
	}

}
