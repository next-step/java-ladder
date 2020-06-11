package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PositionTest {

    @Test
    @DisplayName("위치 생성 테스트")
    void create() {
        assertThatCode(() -> new Position(Direction.LEFT)).doesNotThrowAnyException();
    }

    @EnumSource(Direction.class)
    @ParameterizedTest
    @DisplayName("current 메소드 실행 테스트")
    void current(Direction direction) {
        Position position = new Position(direction);
        assertThat(position.currentDirection()).isEqualTo(direction);
    }

    @EnumSource(value = Direction.class, names = {"RIGHT"})
    @ParameterizedTest
    @DisplayName("next 메소드 실행 테스트")
    void next(Direction direction) {
        Position position = new Position(direction);
        Position nextPosition = position.next(() -> true);
        assertThat(nextPosition.currentDirection()).isEqualTo(Direction.LEFT);
    }

    @EnumSource(value = Direction.class, names = {"RIGHT"})
    @ParameterizedTest
    @DisplayName("last 메소드 실행 테스트")
    void last(Direction direction) {
        Position position = new Position(direction);
        assertThat(position.last()).isEqualTo(new Position(Direction.LEFT));
    }
}
