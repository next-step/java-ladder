package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = Ladder.of(5, 4);

        assertThat(ladder.ladderLines().size()).isEqualTo(5);
    }
}
