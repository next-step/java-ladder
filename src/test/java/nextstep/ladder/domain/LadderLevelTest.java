package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLevelTest {

    @Test
    void create() {
        LadderLevel ladderLevel = LadderLevel.of(9);

        assertThat(ladderLevel.count()).isEqualTo(8);
    }
}
