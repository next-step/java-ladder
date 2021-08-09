package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.strategy.DirectionStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.fixture.LadderFixture.*;

/**
 * LadderColumn은 사다리의 열을 의미한다. 확장성을 위해 LadderCell이라는 indirection 계층을 두었다.
 */
class LadderColumnTest {
    @Test
    @DisplayName("첫 Column이 오른쪽으로 이어져 있으면 참을 반환한다.")
    void createFirstTrue() {
        LadderColumn firstColumn = LadderColumn.createFirst(DIRECTION_TRUE);
        Assertions.assertThat(firstColumn.isRight()).isTrue();
    }

    @Test
    @DisplayName("첫 Column이 오른쪽으로 이어져 있지 않으면 있으면 거짓을 반환한다.")
    void createFirstFalse() {
        LadderColumn firstColumn = LadderColumn.createFirst(DIRECTION_FALSE);
        Assertions.assertThat(firstColumn.isRight()).isFalse();
    }

    /**
     * <pre>
     *     |-----|-----|     | <- 불가
     *     |     |-----|     |
     *     |-----|     |-----|
     *     |     |-----|     |
     * </pre>
     */
    @Test
    @DisplayName("첫 Column이 오른쪽으로 이어져 있으면 다음 Column은 절대로 오른쪽으로 이어질 수 없다.")
    void createNextTrue() {
        LadderColumn nextColumn = FIRST_TRUE_COLUMN.createNext(DIRECTION_FALSE);
        Assertions.assertThat(nextColumn.isRight()).isFalse();
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("첫 Column이 오른쪽으로 이어져 있지 않으면 다음 Column은 이어질 수도 있고 안 이어질 수도 있다.")
    void createNextFalse(final LadderColumn firstColumn, final DirectionStrategy strategy, final boolean expected) {
        LadderColumn nextColumn = firstColumn.createNext(strategy);
        Assertions.assertThat(nextColumn.isRight()).isEqualTo(expected);
    }

    private static Stream<Arguments> createNextFalse() {
        return Stream.of(
                Arguments.of(FIRST_FALSE_COLUMN, DIRECTION_FALSE, false),
                Arguments.of(FIRST_FALSE_COLUMN, DIRECTION_TRUE, true)
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("마지막 Column은 이전 Column의 상태가 어떻든 절대로 더이상 오른쪽으로 이어질 수 없다.")
    void createLast(final LadderColumn firstColumn, final DirectionStrategy strategy) {
        LadderColumn lastColumn = firstColumn.createNext(strategy).createLast();
        Assertions.assertThat(lastColumn.isRight()).isFalse();
    }

    private static Stream<Arguments> createLast() {
        return Stream.of(
                Arguments.of(FIRST_FALSE_COLUMN, DIRECTION_FALSE),
                Arguments.of(FIRST_FALSE_COLUMN, DIRECTION_TRUE)
        );
    }
}
