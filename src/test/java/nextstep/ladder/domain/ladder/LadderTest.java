package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    void 사다리_정상_생성(){
        Ladder ladder = new Ladder(0, 0, true);
        assertThat(ladder.getPosition()).isEqualTo(new LadderPosition(0, 0));
        assertThat(ladder.isHasHorizontalLine()).isTrue();
    }

}
