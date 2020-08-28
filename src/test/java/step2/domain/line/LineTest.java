package step2.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Coordinate;
import step2.domain.direction.Direction;
import step2.domain.point.Point;
import step2.domain.line.Line;
import step2.exception.LadderGameException;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static step2.domain.Coordinate.LINE_START_COORDINATE;

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
