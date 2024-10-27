package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리_생성() {
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
        Ladder ladder = new Ladder(line);
        assertThat(ladder).isEqualTo(new Ladder(line));
    }
}
