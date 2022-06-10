package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DirectionTest {

    @Test
    @DisplayName("다음 Direction 의 방향 테스트")
    public void nextDirectionTest () {
        Direction direction = new Direction(false, true).next();
        Direction result = new Direction(true, false);

        Assertions.assertThat(direction).isEqualTo(result);
    }

    private static Stream<Arguments> directionTestArgs() {
        return Stream.of(
                arguments(new Direction(false, true), false, true),
                arguments(new Direction(false, false), false, false),
                arguments(new Direction(true, false), true, false)
        );
    }

    @ParameterizedTest
    @MethodSource("directionTestArgs")
    @DisplayName("왼쪽 or 오른쪽 체크 테스트")
    public void DirectionTest (Direction direction, boolean leftResult, boolean rightResult) {
        Assertions.assertThat(direction.isLeft()).isEqualTo(leftResult);
        Assertions.assertThat(direction.isRight()).isEqualTo(rightResult);
    }


    @Test
    @DisplayName("마지막 direction 의 방향 테스트")
    public void t() {
        Direction direction1 = new Direction(false, true);
        Assertions.assertThat(direction1.last()).isEqualTo(new Direction(true, false));

        Direction direction2 = new Direction(true, false);
        Assertions.assertThat(direction2.last()).isEqualTo(new Direction(false, false));
    }
}
