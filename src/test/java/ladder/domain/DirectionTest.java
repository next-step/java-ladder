package ladder.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

    private Direction canMoveNextDirection;
    private Direction canNotMoveNextDirection;

    @BeforeEach
    public void setUp() {
        canMoveNextDirection = Direction.firstDirectionOfPoint(() -> true);
        canNotMoveNextDirection = Direction.firstDirectionOfPoint(() -> false);
    }

    @DisplayName("첫 포인트의 방향 테스트")
    @Test
    public void createFirstPoint() {
        assertAll(
                () -> assertThat(canMoveNextDirection.canMoveNext()).isTrue(),
                () -> assertThat(canMoveNextDirection.canMovePrevious()).isFalse(),
                () -> assertThat(canNotMoveNextDirection.canMovePrevious()).isFalse(),
                () -> assertThat(canNotMoveNextDirection.canMovePrevious()).isFalse()
        );
    }

    @DisplayName("마지막 포인트의 방향 테스트")
    @Test
    public void createLastPoint() {
        assertAll(
                () -> assertThat(canMoveNextDirection.lastDirectionOfPoint().canMoveNext()).isFalse(),
                () -> assertThat(canMoveNextDirection.lastDirectionOfPoint().canMovePrevious()).isTrue(),
                () -> assertThat(canNotMoveNextDirection.lastDirectionOfPoint().canMoveNext()).isFalse(),
                () -> assertThat(canNotMoveNextDirection.lastDirectionOfPoint().canMovePrevious()).isFalse()
        );
    }

    @ParameterizedTest(name = "다음 포인트의 방향 반환 테스트, previousExpected : {1} nextExpected : {2}")
    @MethodSource("nextDirection")
    public void createNextpoint (Direction direction, boolean previousExpected, boolean nextExpected) {
        assertAll(
                () -> assertThat(direction.canMovePrevious()).isEqualTo(previousExpected),
                () -> assertThat(direction.canMoveNext()).isEqualTo(nextExpected)
        );
    }

    private static Stream<Arguments> nextDirection() {
        return Stream.of(
                Arguments.arguments(Direction.firstDirectionOfPoint(() -> true).nextDirectionOfPoint(() -> true), true, false),
                Arguments.arguments(Direction.firstDirectionOfPoint(() -> true).nextDirectionOfPoint(() -> false), true, false),
                Arguments.arguments(Direction.firstDirectionOfPoint(() -> false).nextDirectionOfPoint(() -> true), false, true),
                Arguments.arguments(Direction.firstDirectionOfPoint(() -> false).nextDirectionOfPoint(() -> false), false, false)
        );
    }
}