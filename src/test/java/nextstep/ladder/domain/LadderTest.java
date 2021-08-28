package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,2", "2,1", "2,2", "10,10"})
    void createLadder(int ladderHeight, int ladderWidth) {
        assertThatCode(() -> new Ladder(ladderHeight, ladderWidth))
            .doesNotThrowAnyException();
    }
}