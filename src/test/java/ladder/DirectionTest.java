package ladder;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private static Stream<Arguments> mockDirectionBuilder() {
        return Stream.of(
                Arguments.of(0, Direction.LEFT),
                Arguments.of(1, Direction.RIGHT),
                Arguments.of(2, Direction.DOWN)
        );
    }

    @DisplayName("Direction Enum 객체 정상 생성 테스트")
    @ParameterizedTest
    @MethodSource("mockDirectionBuilder")
    public void getDirection(int index, Direction expectedDirection) {
        Direction direction = Direction.values()[index];

        assertThat(direction).isEqualTo(expectedDirection);
    }

    @DisplayName("Direction의 moveIndexByDirection 메소드 테스트")
    @Test
    public void moveIndexByDirection() {
        int index = 3;

        int leftIndex = Direction.LEFT.moveIndexByDirection(index);
        int rightIndex = Direction.RIGHT.moveIndexByDirection(index);
        int downIndex = Direction.DOWN.moveIndexByDirection(index);

        assertThat(leftIndex).isEqualTo(2);
        assertThat(rightIndex).isEqualTo(4);
        assertThat(downIndex).isEqualTo(3);
    }
}
