package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("Direction이 Right인 경우 Input 상관없이 next는 Left를 리턴")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @EnumSource(value = Direction.class, mode = EnumSource.Mode.EXCLUDE, names = {"RIGHT"})
    void next_ReturnLeftDirection_IfItsRightDirection(Direction input) {
        Direction next = Direction.RIGHT.next(input);
        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Direction이 Right가 아닌 경우 Input Direction을 리턴")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @EnumSource
    void next_ReturnInputDirection_IfItsNotRightDirection(Direction input) {
        Direction next = Direction.LEFT.next(input);
        assertThat(next).isEqualTo(input);

        next = Direction.NONE.next(input);
        assertThat(next).isEqualTo(input);
    }

    @DisplayName("Direction이 Right인 경우 last는 Left를 리턴")
    @Test
    void last_ReturnLeftDirection_IfItsRightDirection() {
        Direction next = Direction.RIGHT.last();
        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Direction이 Right가 아닌 경우 last는 None 리턴")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @EnumSource(value = Direction.class, mode = EnumSource.Mode.EXCLUDE, names = {"RIGHT"})
    void last_ReturnNoneDirection_IfItsNotRightDirection(Direction direction) {
        Direction next = direction.last();
        assertThat(next).isEqualTo(Direction.NONE);
    }

    @DisplayName("Direction이 Right인 경우 isRight는 true를 리턴")
    @Test
    void isRight() {
        Direction direction = Direction.RIGHT;
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("Direction이 Left인 경우 isLeft는 true를 리턴")
    @Test
    void isLeft() {
        Direction direction = Direction.LEFT;
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("Direction 방향에 따라 move 포지션 값 이동")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void move(Direction direction, int position, int expected) {
        Position result = direction.move(new Position(position));
        assertThat(result).isEqualTo(new Position(expected));
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(Direction.RIGHT, 5, 6),
                Arguments.of(Direction.LEFT, 5, 4),
                Arguments.of(Direction.NONE, 5, 5)
        );
    }
}