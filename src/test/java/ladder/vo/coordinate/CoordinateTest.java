package ladder.vo.coordinate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

    @Test
    public void 좌표_왼쪽_좌표_가져오기() {
        // given
        Coordinate coordinate = getCoordinate(1, 1);

        // when
        Coordinate left = coordinate.left();

        // then
        assertThat(left).isEqualTo(getCoordinate(0, 1));
    }

    @Test
    public void 좌표_오른쪽_좌표_가져오기() {
        // given
        Coordinate coordinate = getCoordinate(1, 1);

        // when
        Coordinate right = coordinate.right();

        // then
        assertThat(right).isEqualTo(getCoordinate(2, 1));
    }

    @Test
    public void 좌표_아래쪽_좌표_가져오기() {
        // given
        Coordinate coordinate = getCoordinate(1, 1);

        // when
        Coordinate down = coordinate.down();

        // then
        assertThat(down).isEqualTo(getCoordinate(1, 0));
    }

    private Coordinate getCoordinate(int x, int y) {
        return new Coordinate(new CoordinateValue(x), new CoordinateValue(y));
    }
}
