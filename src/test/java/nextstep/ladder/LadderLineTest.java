package nextstep.ladder;

import nextstep.ladder.domain.LadderLine;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class LadderLineTest {

    @Test
    void create() {
        assertThat(LadderLine.init(5).size()).isEqualTo(5);
    }
}