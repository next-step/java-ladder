package nextstep.ladder;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class LadderLineTest {

    @Test
    void create() {
        assertThat(LadderLine.init(5).size()).isEqualTo(5);
    }
}