package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalMoveStrategyTests {
    @DisplayName("정적 팩토리 메서드에 전달된 인자에 맞는 정책 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("moveStrategySource")
    void createTest(Direction direction, HorizontalMoveStrategy result) {
        assertThat(HorizontalMoveStrategy.findByDirection(direction)).isEqualTo(result);
    }
    public static Stream<Arguments> moveStrategySource() {
        return Stream.of(
                Arguments.of(new Direction(true, false), HorizontalMoveStrategy.MOVE_LEFT),
                Arguments.of(new Direction(false, true), HorizontalMoveStrategy.MOVE_RIGHT),
                Arguments.of(new Direction(false, false), HorizontalMoveStrategy.STAY)
        );
    }
}
