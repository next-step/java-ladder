package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("사라디의 한 행의 각 지점, 첫 번째 지점을 생성한다.")
    @Test
    void createPointTest() {
        Point.of(Position.from(5), Direction.of(true, false));
        Point.first(() -> true);
    }

    @DisplayName("사라디의 한 행의 어떤 지점을 생성할 때 index가 0보다 작으면 예외가 발생한다.")
    @Test
    void createPointTestFail() {
        assertThatThrownBy(() -> Point.of(Position.from(-1), Direction.of(true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사라디의 어떤 지점을 기준으로 다음 지점을 생성한다. - 이전 지점과 다음 지점이 연결되는 경우")
    @Test
    void createNextPointTestRight() {
        Point next = Point.first(() -> true).next(() -> true);
        assertThat(next)
                .isEqualTo(Point.of(Position.from(1), Direction.of(true, false)));
    }

    @DisplayName("사라디의 어떤 지점을 기준으로 다음 지점을 생성한다. - 이전 지점과 다음 지점이 연결되지 않는 경우")
    @Test
    void createNextPointTestNotRight() {
        Point next = Point.first(() -> false).next(() -> true);
        assertThat(next)
                .isEqualTo(Point.of(Position.from(1), Direction.of(false, true)));
    }

    @DisplayName("마지막 지점을 생성하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void createLastPointTest(boolean connected) {
        Point point = Point.of(Position.from(10), Direction.of(false, connected));
        assertThat(point.last())
                .isEqualTo(Point.of(Position.from(11), Direction.of(connected,false)));
    }

    @DisplayName("각 지점에서 좌, 우 이동 또는 정지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:false:-1", "false:true:1", "false:false:0"}, delimiter = ':')
    void moveTest(boolean left, boolean right, int distance) {
        assertThat(Point.of(Position.from(10), Direction.of(left, right)).move())
                .isEqualTo(Position.from(10 + distance));
    }
}
