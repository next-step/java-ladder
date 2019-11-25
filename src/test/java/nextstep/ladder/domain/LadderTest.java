package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 객체생성() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder).isNotEqualTo(new Ladder(4, 5));
    }

    @Test
    void 사다리_라인_생성() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder).isNotEqualTo(new Ladder(4, 2));
    }
}