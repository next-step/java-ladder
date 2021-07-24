package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    void create() {
        Winner winner = Winner.of(Member.of("pobi"), Prize.of("5000"));
        Winners winners = Winners.create(Collections.singletonList(winner));
        assertThat(winners.get(0)).isEqualTo(winner);
    }
}