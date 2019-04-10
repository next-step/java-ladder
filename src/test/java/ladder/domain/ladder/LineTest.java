package ladder.domain.ladder;

import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    public void Line의_Point가_하나일_경우_IllegalArgumentException() {
        // (참가자가 한 명일 경우)
        // given
        Point point = Point.LEFT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point)));
    }

    @Test
    public void 가장_왼쪽의_Point가_왼쪽으로_건너갈_수_있는_경우_IllegalArgumentException() {
        // given
        Point point = Point.LEFT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point, point)));
    }

    @Test
    public void 가장_오른쪽의_Point가_오른쪽으로_건너갈_수_있는_경우_IllegalArgumentException() {
        // given
        Point point = Point.RIGHT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point, point)));
    }

    @Test
    public void 인접한_Point_끼리_Cross가_일치하지_않는_경우_IllegalArgumentException() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT, Point.LEFT_CROSS_POINT)));
    }

    @Test
    public void Line에서_좌표_좌우로_넘어가기() {
        // given
        /**
         * | --- |     |
         */
        List<Point> points = Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT, Point.CANNOT_CROSS_POINT);
        Line line = new Line(points);

        Coordinate firstCoordinate = getCoordinate(0, 0);
        Coordinate secondCoordinate = getCoordinate(1, 0);
        Coordinate thirdCoordinate = getCoordinate(2, 0);

        // when
        Coordinate shouldBeSecond = line.cross(firstCoordinate);
        Coordinate shouldBeFirst = line.cross(secondCoordinate);
        Coordinate shouldBeThird = line.cross(thirdCoordinate);

        // then
        assertThat(shouldBeFirst).isEqualTo(getCoordinate(0, 0));
        assertThat(shouldBeSecond).isEqualTo(getCoordinate(1, 0));
        assertThat(shouldBeThird).isEqualTo(getCoordinate(2, 0));
    }

    private Coordinate getCoordinate(int x, int y) {
        return new Coordinate(new CoordinateValue(x), new CoordinateValue(y));
    }
}
