package nextstep.ladder.domain.alternative;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Point 요구사항
 * <p>
 * * 포인트는 위치와 이동가능여부(Direction) 을 가진다.
 * * 이동 함수를 제공하며 위치값을 반환한다
 */
public class PointTest {
    @Test
    void create() {
        new Point(0, Direction.of(false, true));
    }

    @DisplayName("첫번째 지점은 오른쪽 이동가능여부를 입력받는다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void first(boolean right) {
        assertThat(Point.first(right)).isEqualTo(new Point(0, Direction.of(false, right)));
    }

    @DisplayName("이동하면 위치값을 리턴한다")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void move(boolean right, int index) {
        assertThat(Point.first(right).move()).isEqualTo(index);
    }

    @DisplayName("두번째 지점이 왼쪽으로 이동하는 경우")
    @Test
    void second_move_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("두번째 지점이 오른쪽으로 이동하는 경우")
    @Test
    void second_move_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("두번째 지점이 이동하지 않는 경우")
    @Test
    void second_move_neutral() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("마지막 지점을 만들 수 있다")
    @ParameterizedTest
    @CsvSource({"true,0", "false,1"})
    void last(boolean right, int index) {
        Point last = Point.first(right).last();
        assertThat(last.move()).isEqualTo(index);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void hasRight(boolean right) {
        assertThat(Point.first(right).hasRight()).isEqualTo(right);
    }
}
