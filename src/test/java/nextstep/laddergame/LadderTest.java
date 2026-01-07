package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import nextstep.laddergame.domain.Ladder;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_높이만큼_Line_을_생성한다() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.line().size()).isEqualTo(3);
    }

}