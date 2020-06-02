package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveStrategyTests {
    @DisplayName("정적 팩토리 메서드에 전달된 인자에 맞는 정책 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("moveStrategySource")
    void createTest(boolean currentPointStatus, boolean nextPointStatus, MoveStrategy result) {
        assertThat(MoveStrategy.create(currentPointStatus, nextPointStatus)).isEqualTo(result);
    }
    public static Stream<Arguments> moveStrategySource() {
        return Stream.of(
                Arguments.of(true, false, MoveStrategy.MOVE_LEFT),
                Arguments.of(false, true, MoveStrategy.MOVE_RIGHT),
                Arguments.of(false, false, MoveStrategy.STAY)
        );
    }

    @DisplayName("존재하지 않는 정책을 요구할 경우 NotExistMoveStrategyException 발생")
    @Test
    void validationTest() {
        assertThatThrownBy(() -> MoveStrategy.create(true, true))
                .isInstanceOf(NotExistMoveStrategyException.class);
    }
}
