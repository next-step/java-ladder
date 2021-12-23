package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.IndexTest.ix;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfRail = 5;
        assertThat(LadderLine.init(sizeOfRail, NO_LINE_STRATEGY)).isEqualTo(LadderLine.init(sizeOfRail, NO_LINE_STRATEGY));
    }

    static Stream<Arguments> parseMoveArguments() {
        return Stream.of(
                Arguments.of(LadderLine.init(2, NO_LINE_STRATEGY), 0, 0),
                Arguments.of(LadderLine.init(2, TestLadderPointStrategy.reverseLineStrategy()), 1, 0),
                Arguments.of(LadderLine.init(2, TestLadderPointStrategy.reverseLineStrategy()), 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parseMoveArguments")
    public void move(LadderLine line, int move, int expected) {
        assertThat(line.move(move)).isEqualTo(ix(expected));
    }
}
