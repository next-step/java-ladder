package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void create() {
        assertThatCode(() -> Ladder.of(5, 5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }
}
