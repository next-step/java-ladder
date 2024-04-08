package nextstep.ladder;

import nextstep.ladder.domain.LinePoint;
import nextstep.ladder.domain.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LinePointTest {

    @ParameterizedTest
    @MethodSource("makeLinePoint")
    @DisplayName("라인 포인트 생성 테스트")
    void testMakeLinePoint(LinePoint linePoint, boolean movableLeft, boolean movableRight) {
        assertThat(linePoint.canMoveLeft()).isEqualTo(movableLeft);
        assertThat(linePoint.canMoveRight()).isEqualTo(movableRight);
    }

    @Test
    @DisplayName("연속적인 라인이 있을 경우 에러 발생")
    void testInvalidLinePoint() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LinePoint(true, true));
    }

    private static Stream<Arguments> makeLinePoint() {
        return Stream.of(
                Arguments.of(LinePoint.of(MoveDirection.RIGHT), false, true),
                Arguments.of(LinePoint.of(MoveDirection.LEFT), true, false),
                Arguments.of(LinePoint.of(MoveDirection.NON), false, false)
        );
    }
}
