package ladder.domain.ladder;

import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사다리의_최종_좌표_결과_가져오기() {
        // given
        /**
         * | --- |     |
         * |     | --- |
         */
        Line secondLine = new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT, Point.CANNOT_CROSS_POINT));
        Line firstLine = new Line(Arrays.asList(Point.CANNOT_CROSS_POINT, Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));

        Ladder ladder = new Ladder(new Lines(Arrays.asList(firstLine, secondLine)));

        // when
        Coordinate shouldBeThird = ladder.getLadderResultCoordinate(getCoordinate(0, 2));
        Coordinate shouldBeFirst = ladder.getLadderResultCoordinate(getCoordinate(1, 2));
        Coordinate shouldBeSecond = ladder.getLadderResultCoordinate(getCoordinate(2, 2));

        // then
        assertThat(shouldBeFirst).isEqualTo(getCoordinate(0, 0));
        assertThat(shouldBeSecond).isEqualTo(getCoordinate(1, 0));
        assertThat(shouldBeThird).isEqualTo(getCoordinate(2, 0));
    }

    private Coordinate getCoordinate(int x, int y) {
        return new Coordinate(new CoordinateValue(x), new CoordinateValue(y));
    }
}
