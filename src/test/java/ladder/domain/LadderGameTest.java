package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderGameTest {
    @ParameterizedTest
    @CsvSource({"3,5,5", "2,6,6", "4,3,3"})
    public void 생성된_사다리_높이_테스트(int countOfPerson, int heightOfLadder, int expectedHeightOfLadder) {
        assertThat(new LadderGame(countOfPerson, heightOfLadder).getLadder().size()).isEqualTo(expectedHeightOfLadder);

    }
}