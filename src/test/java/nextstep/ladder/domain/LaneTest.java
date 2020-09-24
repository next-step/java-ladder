package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaneTest {

    @Test
    @DisplayName("팩토리 메소드 유효성 검사")
    void of_validateIndex() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Lane.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndLane")
    @DisplayName("Direction에 따른 인덱스 변경")
    void change(int beforeIndex, Direction direction, int afterIndex) {
        Lane actual = Lane.of(beforeIndex).change(direction);
        Lane expected = Lane.of(afterIndex);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDirectionAndLane() {
        return Stream.of(
                Arguments.of(0, Direction.RIGHT, 1),
                Arguments.of(1, Direction.RIGHT, 2),
                Arguments.of(1, Direction.LEFT, 0)
        );
    }
}
