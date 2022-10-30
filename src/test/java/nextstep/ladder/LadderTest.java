package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void executeLadder(int startPosition, int movePosition) {
        Ladder ladder = new Ladder(5, 4, new TrueGenerator());
        assertThat(ladder.executeLadder(startPosition)).isEqualTo(movePosition);
    }
}