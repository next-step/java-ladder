package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리높이는_최소_2이상이어야_한다() {
        assertThatThrownBy(() -> {
           new Ladder(1, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}