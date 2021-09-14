package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @DisplayName("라인 연결 정보로 포인트 리스트를 생성할 수 있다.")
    @Test
    public void createPointsTest() {
        List<Point> points = Point.listOf(Arrays.asList(LineConnection.CONNECTED, LineConnection.UNCONNECTED));
        List<Point> expected = Arrays.asList(
                new Point(0, Direction.RIGHT),
                new Point(1, Direction.LEFT),
                new Point(2, Direction.DOWN)
        );
        assertThat(points).isEqualTo(expected);
    }

    @DisplayName("라인 연결 정보로 포인트 리스트 생성 시, 예외가 발생한다.")
    @Test
    public void invalidConnectionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.listOf(Arrays.asList(LineConnection.CONNECTED, LineConnection.CONNECTED)));
    }

}