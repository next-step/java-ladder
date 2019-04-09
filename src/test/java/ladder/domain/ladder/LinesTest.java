package ladder.domain.ladder;

import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LinesTest {

    @Test
    public void Line_들의_size가_전부_일치하지_않는_경우_IllegalArgumentException() {
        // given
        Point point = new Point(Cross.NOT_CROSS, Cross.NOT_CROSS);
        Line two = new Line(Arrays.asList(point, point));
        Line three = new Line(Arrays.asList(point, point, point));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lines(Arrays.asList(two, two, three)));
    }

    @Test
    public void 라인을_따라_다음_라인으로_건너가기() {
        // given
        /**
         * | --- |     |
         * |     | --- |
         */
        Line topLine = new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT, Point.CANNOT_CROSS_POINT));
        Line bottomLine = new Line(Arrays.asList(Point.CANNOT_CROSS_POINT, Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));
        Lines lines = new Lines(Arrays.asList(topLine, bottomLine));

        Coordinate firstCoordinate = getCoordinate(0, 2);
        Coordinate secondCoordinate = getCoordinate(1, 2);
        Coordinate thirdCoordinate = getCoordinate(2, 2);

        // when
        Coordinate shouldBeSecond = lines.cross(firstCoordinate);
        Coordinate shouldBeFirst = lines.cross(secondCoordinate);
        Coordinate shouldBeThird = lines.cross(thirdCoordinate);

        // then
        assertThat(shouldBeFirst).isEqualTo(getCoordinate(0, 1));
        assertThat(shouldBeSecond).isEqualTo(getCoordinate(1, 1));
        assertThat(shouldBeThird).isEqualTo(getCoordinate(2, 1));
    }

    private Coordinate getCoordinate(int x, int y) {
        return new Coordinate(new CoordinateValue(x), new CoordinateValue(y));
    }
}
