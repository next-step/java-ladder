package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    void create() {
        Winner winner = Winner.of(Member.of("pobi"), Prize.of("5000"));
        assertThatCode(() -> Winners.create(Collections.singletonList(winner))).doesNotThrowAnyException();
    }
}