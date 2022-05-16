package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMakerTest {
    @Test
    @DisplayName("사다리 높이가 6이면 라인수는 6개이다")
    void size() {
        LadderMaker ladderMaker = new LadderMaker(new LineMaker(5));
        assertThat(ladderMaker.makeLadder(6).getLines()).hasSize(6);
    }
}
