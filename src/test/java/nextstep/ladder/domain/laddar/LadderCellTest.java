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
 * LadderCell은 사다리의 행과 열이 만나는 지점의 칸을 의미한다. 각 Cell은 옆 Cell과 이어져 있는지 여부를 알기 위해 Direction을 의존한다.
 */
class LadderCellTest {
    @Test
    @DisplayName("첫 Cell이 오른쪽으로 이어져 있으면 참을 반환한다.")
    void createFirstTrue() {
        LadderCell firstCell = LadderCell.createFirst(DIRECTION_TRUE);
        Assertions.assertThat(firstCell.isRight()).isTrue();
    }

    @Test
    @DisplayName("첫 Cell이 오른쪽으로 이어져 있지 않으면 있으면 거짓을 반환한다.")
    void createFirstFalse() {
        LadderCell firstCell = LadderCell.createFirst(DIRECTION_FALSE);
        Assertions.assertThat(firstCell.isRight()).isFalse();
    }

    /**
     * <pre>
     *     |-----|-----|     | <- 불가
     *     |     |-----|     |
     *     |-----|     |-----|
     *     |     |-----|     |
     * </pre>
     */
    @MethodSource
    @ParameterizedTest
    @DisplayName("첫 Cell이 오른쪽으로 이어져 있으면 다음 Cell은 절대로 오른쪽으로 이어질 수 없다.")
    void createNextTrue(final LadderCell firstCell, final DirectionStrategy strategy, final boolean expected) {
        LadderCell nextCell = firstCell.createNext(strategy);
        Assertions.assertThat(nextCell.isRight()).isEqualTo(expected);
    }

    private static Stream<Arguments> createNextTrue() {
        return Stream.of(
                Arguments.of(FIRST_TRUE_CELL, DIRECTION_TRUE, false),
                Arguments.of(FIRST_TRUE_CELL, DIRECTION_FALSE, false)
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("첫 Cell이 오른쪽으로 이어져 있지 않으면 다음 Cell은 이어질 수도 있고 안 이어질 수도 있다.")
    void createNextFalse(final LadderCell firstCell, final DirectionStrategy strategy, final boolean expected) {
        LadderCell nextCell = firstCell.createNext(strategy);
        Assertions.assertThat(nextCell.isRight()).isEqualTo(expected);
    }

    private static Stream<Arguments> createNextFalse() {
        return Stream.of(
                Arguments.of(FIRST_FALSE_CELL, DIRECTION_FALSE, false),
                Arguments.of(FIRST_FALSE_CELL, DIRECTION_TRUE, true)
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("마지막 Cell은 이전 Cell의 상태가 어떻든 절대로 더이상 오른쪽으로 이어질 수 없다.")
    void createLast(final LadderCell firstCell, final DirectionStrategy strategy) {
        LadderCell lastCell = firstCell.createNext(strategy).createLast();
        Assertions.assertThat(lastCell.isRight()).isFalse();
    }

    private static Stream<Arguments> createLast() {
        return Stream.of(
                Arguments.of(FIRST_FALSE_CELL, DIRECTION_FALSE),
                Arguments.of(FIRST_FALSE_CELL, DIRECTION_TRUE)
        );
    }
}
