package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Direction;
import step2.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

;

public class TempTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,3", "2,2", "3,1"})
	void test(Integer startIndex, Integer result) {
		String message = "현재 좌표 : (%d, %d)";
		List<Point> firstLine = List.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT), new Point(2, Direction.RIGHT), new Point(3, Direction.LEFT));
		List<Point> secondLine = List.of(new Point(0, Direction.DOWN), new Point(1, Direction.RIGHT), new Point(2, Direction.LEFT), new Point(3, Direction.DOWN));
		List<Point> thirdLine = List.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT), new Point(2, Direction.DOWN), new Point(3, Direction.DOWN));
		List<Point> fourthLine = List.of(new Point(0, Direction.DOWN), new Point(1, Direction.RIGHT), new Point(2, Direction.LEFT), new Point(3, Direction.DOWN));
		List<Point> fifthLine = List.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT), new Point(2, Direction.RIGHT), new Point(3, Direction.LEFT));
		Point firstPoint = firstLine.get(startIndex);
		System.out.println(String.format(message, 0, startIndex));

		Integer secondIndex = firstPoint.goNextPoint();
		Point secondPoint = secondLine.get(secondIndex);
		System.out.println(String.format(message, 1, secondIndex));

		Integer thirdIndex = secondPoint.goNextPoint();
		Point thirdPoint = thirdLine.get(thirdIndex);
		System.out.println(String.format(message, 2, thirdIndex));

		Integer fourthIndex = thirdPoint.goNextPoint();
		Point fourthPoint = fourthLine.get(fourthIndex);
		System.out.println(String.format(message, 3, fourthIndex));

		Integer fifthIndex = fourthPoint.goNextPoint();
		Point fifthPoint = fifthLine.get(fifthIndex);
		System.out.println(String.format(message, 4, fifthIndex));

		Integer finalIndex = fifthPoint.goNextPoint();
		System.out.println(String.format(message, 5, finalIndex));

		assertThat(finalIndex).isEqualTo(result);
	}
}
