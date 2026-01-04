package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_높이만큼_Line_을_생성한다() {
        Ladder ladder = new Ladder(3);
        assertThat(ladder.getLine().size()).isEqualTo(3);
    }

}