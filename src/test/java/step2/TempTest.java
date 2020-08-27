package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Coordinate;
import step2.domain.Direction;
import step2.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TempTest {
	private static final String message = "현재 좌표 : (%d, %d)";
	private static final List<List<Point>> ladder;
	private static final Coordinate ZERO = new Coordinate(0);
	private static final Coordinate ONE = new Coordinate(1);
	private static final Coordinate TWO = new Coordinate(2);
	private static final Coordinate THREE = new Coordinate(3);

	static {
		List<Point> firstLine = List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.RIGHT), new Point(THREE, Direction.LEFT));
		List<Point> secondLine = List.of(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN));
		List<Point> thirdLine = List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.DOWN), new Point(THREE, Direction.DOWN));
		List<Point> fourthLine = List.of(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN));
		List<Point> fifthLine = List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.RIGHT), new Point(THREE, Direction.LEFT));
		ladder = List.of(firstLine, secondLine, thirdLine, fourthLine, fifthLine);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,3", "2,2", "3,1"})
	void test(Integer startIndex, Integer result) {

		Integer lineIndex = startIndex;

		for(int i = 0 ; i < ladder.size() ; i ++) {
			List<Point> line = ladder.get(i);
			Point point = line.get(lineIndex);
			System.out.println(String.format(message, i, lineIndex));
			lineIndex = point.goNextPoint().getCoordinate();
		}

		assertThat(lineIndex).isEqualTo(result);
	}
}
