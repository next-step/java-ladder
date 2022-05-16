package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("사라디의 한 행의 각 지점, 첫 번째 지점을 생성한다.")
    @Test
    void createPointTest() {
        Point.of(5, Direction.of(true, false));
        Point.first(() -> true);
    }

    @DisplayName("사라디의 한 행의 어떤 지점을 생성할 때 index가 0보다 작으면 예외가 발생한다.")
    @Test
    void createPointTestFail() {
        assertThatThrownBy(() -> Point.of(-1, Direction.of(true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사라디의 어떤 지점을 기준으로 다음 지점을 생성한다. - 이전 지점과 다음 지점이 연결되는 경우")
    @Test
    void createNextPointTestRight() {
        Point next = Point.first(() -> true).next(() -> true);
        assertThat(next)
                .isEqualTo(Point.of(1, Direction.of(true, false)));
    }

    @DisplayName("사라디의 어떤 지점을 기준으로 다음 지점을 생성한다. - 이전 지점과 다음 지점이 연결되지 않는 경우")
    @Test
    void createNextPointTestNotRight() {
        Point next = Point.first(() -> false).next(() -> true);
        assertThat(next)
                .isEqualTo(Point.of(1, Direction.of(false, true)));
    }

    @DisplayName("마지막 지점을 생성하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void createLastPointTest(boolean connected) {
        Point point = Point.of(10, Direction.of(false, connected));
        assertThat(point.last())
                .isEqualTo(Point.of(11, Direction.of(connected,false)));
    }
}
