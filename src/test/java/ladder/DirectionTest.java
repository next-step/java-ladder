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
    public void direction_정상_생성(int index, Direction expectedDirection) {
        Direction direction = Direction.values()[index];

        assertThat(direction).isEqualTo(expectedDirection);
    }

    @DisplayName("Direction이 LEFT면 index의 값을 1 마이너스")
    @Test
    public void moveIndexByDirection_왼쪽() {
        int result = Direction.LEFT.moveIndexByDirection(3);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("Direction이 RIGHT면 index의 값을 1 플러스")
    @Test
    public void moveIndexByDirection_오른쪽() {
        int result = Direction.RIGHT.moveIndexByDirection(3);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("Direction이 Down이면 index의 값 변화 없음")
    @Test
    public void moveIndexByDirection_아래쪽() {
        int result = Direction.DOWN.moveIndexByDirection(3);

        assertThat(result).isEqualTo(3);
    }
}
