package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PointTest {

    @Test
    @DisplayName("위치 생성 테스트")
    void create() {
        assertThatCode(() -> new Point(Direction.LEFT)).doesNotThrowAnyException();
    }

    @EnumSource(Direction.class)
    @ParameterizedTest
    @DisplayName("current 메소드 실행 테스트")
    void current(Direction direction) {
        Point point = new Point(direction);
        assertThat(point.currentDirection()).isEqualTo(direction);
    }

    @EnumSource(value = Direction.class, names = {"RIGHT"})
    @ParameterizedTest
    @DisplayName("next 메소드 실행 테스트")
    void next(Direction direction) {
        Point point = new Point(direction);
        Point nextPoint = point.next(() -> true);
        assertThat(nextPoint.currentDirection()).isEqualTo(Direction.LEFT);
    }

    @EnumSource(value = Direction.class, names = {"RIGHT"})
    @ParameterizedTest
    @DisplayName("last 메소드 실행 테스트")
    void last(Direction direction) {
        Point point = new Point(direction);
        assertThat(point.last()).isEqualTo(new Point(Direction.LEFT));
    }

    @Test
    @DisplayName("Point first 메소드 실행 테스트")
    void first() {
        Point point = Point.first(() -> true);
        assertThat(point.currentDirection()).isNotEqualTo(Direction.LEFT);
    }

    @ValueSource(ints =  {-1, 0, 1})
    @ParameterizedTest
    @DisplayName("move 메소드 실행 테스트")
    void move(int value) {
        Direction direction = Direction.of(value);
        Point point = new Point(direction);
        assertThat(point.move()).isEqualTo(value);
    }
}
