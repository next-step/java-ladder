package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리_생성() {
        int userCount = 4;
        int ladderMaxHeight = 5;

        // when
        Ladder ladder = new Ladder(userCount, ladderMaxHeight);

        // then
        Assertions.assertThat(ladder.size()).isEqualTo(ladderMaxHeight);
    }
}
