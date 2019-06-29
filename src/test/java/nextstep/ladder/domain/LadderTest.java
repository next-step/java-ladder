package nextstep.ladder.domain;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class LadderTest {
    @Test
    void create() {
        int rowSize = 5;
        Ladder ladder = new Ladder(5);

        assertThat(ladder.size()).isEqualTo(rowSize);
    }

    @Test
    void 사다리_높이는_1이상() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(0));
    }
}
