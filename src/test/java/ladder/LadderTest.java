package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리_생성() {
        int countOfPerson = 3;
        int ladderHeight = 5;
        Ladder ladder = new Ladder(countOfPerson, ladderHeight);
        String error = "true, true";

        Line firstLine = ladder.getLine(0);
        assertThat(firstLine.toString().contains(error)).isFalse();
    }
}