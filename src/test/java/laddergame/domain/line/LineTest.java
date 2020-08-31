package laddergame.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import laddergame.domain.Coordinate;
import laddergame.domain.direction.Direction;
import laddergame.domain.point.Point;
import laddergame.exception.LadderGameException;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static laddergame.domain.Coordinate.LINE_START_COORDINATE;

class LineTest {

	@DisplayName("객체 생성 테스트")
	@Test
	void constructionTest() {
		List<Point> line = List.of(new Point(new Coordinate(0), Direction.RIGHT),
										new Point(new Coordinate(1), Direction.LEFT),
										new Point(new Coordinate(2), Direction.RIGHT),
										new Point(new Coordinate(3), Direction.LEFT));
		LinkedList linkedList = new LinkedList(line);
		assertThat(new Line(linkedList)).isEqualTo(new Line(linkedList));
	}

	@DisplayName("Line에 좌표 추가 테스트")
	@Test
	void addPoint() {
		Line line = new Line();
		line.addPoint(new Point(LINE_START_COORDINATE, Direction.RIGHT));
		line.addPoint(new Point(new Coordinate(1), Direction.LEFT));
	}

	@DisplayName("사다리가 겹치는 좌표를 추가하면 Exception 발생")
	@Test
	void addPointException() {
		Line line = new Line();
		line.addPoint(new Point(LINE_START_COORDINATE, Direction.RIGHT));
		assertThrows(LadderGameException.class, () -> line.addPoint(new Point(new Coordinate(1), Direction.RIGHT)));
	}

}
